package 行为变化.visitor;

class Visitor1 extends Visitor {
    public void visitElementA() {
        System.out.println("visitor1对具体实现A的扩展");
    }
    
    public void visitElementB() {
        System.out.println("visitor1对具体实现B的扩展");
    }
}
