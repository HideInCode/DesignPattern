package 行为型模式;

/**
 * 对于代码结构设计时,预留一个借口用来扩展.
 * 要求这个结构的实现类个数一般是稳定的,不然还要去修改visitor,这依赖了具体实现.
 * 使用场景:访问者可以对功能进行统一，可以做报表、UI、拦截器与过滤器。
 */

abstract class Visitor {
    //访问具体类,给他做扩展,其实这里可以看出依赖具体类,违反依赖倒置原则.
    public abstract void visitElementA();
    
    public abstract void visitElementB();
    
}

class Visitor1 extends Visitor {
    public void visitElementA() {
        System.out.println("visitor1对具体实现A的扩展");
    }
    
    public void visitElementB() {
        System.out.println("visitor1对具体实现B的扩展");
    }
}

class Visitor2 extends Visitor {
    public void visitElementA() {
        System.out.println("visitor2对具体实现A的扩展");
        
    }
    
    public void visitElementB() {
        System.out.println("visitor2对具体实现A的扩展");
        
    }
}


//重点就是确保这个类有几个子类,预留个扩展接口
abstract class Element {
    //预留接口 用于添加新的功能
    public abstract void acceptVisitor(Visitor visitor);
}

class ElementA extends Element {
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitElementA();
    }
}

class ElementB extends Element {
    public void acceptVisitor(Visitor visitor) {
        visitor.visitElementB();
    }
}


public class VistorClient {
    public static void main(String[] args) {
        Element element = new ElementA();
        //这里运用了传说中的double-patch之两次分发的技巧
        element.acceptVisitor(new Visitor1());
    }
}
