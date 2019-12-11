package 行为变化.visitor;

class ElementB extends Element {
    public void acceptVisitor(Visitor visitor) {
        visitor.visitElementB(this);
    }
}
