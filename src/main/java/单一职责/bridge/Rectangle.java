package 单一职责.bridge;

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Rectangle.createShape");
    }
}
