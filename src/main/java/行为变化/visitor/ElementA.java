package 行为变化.visitor;

class ElementA extends Element {
    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visitElementA();
    }
}
