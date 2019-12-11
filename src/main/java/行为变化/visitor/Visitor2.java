package 行为变化.visitor;

class Visitor2 extends Visitor {
    @Override
    public void visitElementA(ElementA a) {
        System.out.println("visitor2对具体实现A的扩展");
        
    }
    
    @Override
    public void visitElementB(ElementB b) {
        System.out.println("visitor2对具体实现A的扩展");
        
    }
}
