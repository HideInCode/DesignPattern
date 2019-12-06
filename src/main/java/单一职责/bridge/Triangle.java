package 单一职责.bridge;

class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Triangle.createShape");
    }
}
