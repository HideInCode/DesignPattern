package 单一职责.bridge;

class Circle extends Shape {
    
    
    public Circle(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Circle.createShape");
    }
}
