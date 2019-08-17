package 行为型模式;

/**
 * 是什么:分开请求者和接受者
 * 为什么:职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，
 * 无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了。
 * 在处理消息的时候以过滤很多道。
 * 怎么做:拦截的类都实现统一接口。统一实现处理请求和传递给下一个的方法(单向链表)
 * 不怎么流行
 */

//就是个链表
abstract class Handler {
    public static final int DEBUG = 0;
    public static final int WARN = 1;
    public static final int ERROR = 2;

    //子类共有
    protected int level;
    protected Handler nextHandler;

    protected void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    private void processMessage(int level) {
        switch (level) {
            case 0:
                System.out.println("debug");
                break;
            case 1:
                System.out.println("warn");
                break;
            case 2:
                System.out.println("error");
                break;
        }
    }
    void hanleProblem(int level) {
        if (this.level < level) {
            processMessage(this.level);
        }
        if (nextHandler != null) {
            nextHandler.hanleProblem(level);
        }
    }
}

class DebugHandler extends Handler {
    public DebugHandler() {
        this.level = 0;
    }


}

class WarnHandler extends Handler {
    public WarnHandler() {
        this.level = 1;
    }


}

class ErrorHandler extends Handler {
    public ErrorHandler() {
        this.level = 2;
    }


}

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
