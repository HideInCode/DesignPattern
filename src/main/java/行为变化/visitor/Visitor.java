package 行为变化.visitor;

/**
 * 对于代码结构设计时,预留一个借口用来扩展.
 * 要求这个结构的实现类个数一般是稳定的,不然还要去修改visitor,这依赖了具体实现.
 * 使用场景:访问者可以对功能进行统一，可以做报表、UI、拦截器与过滤器。
 */

abstract class Visitor {
    //访问具体类,给他做扩展,其实这里可以看出依赖具体类,违反依赖倒置原则.
    public abstract void visitElementA(ElementA a);
    
    public abstract void visitElementB(ElementB b);
    
}
