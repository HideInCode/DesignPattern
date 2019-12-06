package 单一职责.bridge;


public class Bridge {
    public static void main(String[] args) {
        //任意组合
        Shape shape = new Rectangle(new Red());
        shape.createShape();
        
    }
}
