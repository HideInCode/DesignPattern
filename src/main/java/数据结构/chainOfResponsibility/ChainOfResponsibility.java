package 数据结构.chainOfResponsibility;


/**
 * 是什么:分开请求者和接受者
 * 为什么:职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，
 * 无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了。
 * 在处理消息的时候以过滤很多道。
 * 怎么做:拦截的类都实现统一接口。统一实现处理请求和传递给下一个的方法(单向链表)
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        Handler debug = new DebugHandler();
        Handler warn = new WarnHandler();
        Handler error = new ErrorHandler();
        error.setNext(warn);
        warn.setNext(debug);

        error.hanleProblem(2);
    }
}
