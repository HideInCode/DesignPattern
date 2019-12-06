package 单一职责.bridge;

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Square.createShape");
    }
}
