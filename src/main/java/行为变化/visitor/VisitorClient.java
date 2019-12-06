package 行为变化.visitor;


public class VisitorClient {
    public static void main(String[] args) {
        Element element = new ElementA();
        //这里运用了传说中的double-patch之两次分发的技巧
        element.acceptVisitor(new Visitor1());
    }
}
