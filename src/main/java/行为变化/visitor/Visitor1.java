package 行为变化.visitor;

class Visitor1 extends Visitor {
    @Override
    public void visitElementA(ElementA a) {
        System.out.println("visitor1对具体实现A的扩展" + a.toString());
    }
    
    public void visitElementB(ElementB b) {
        System.out.println("visitor1对具体实现B的扩展" + b.toString());
    }
}
