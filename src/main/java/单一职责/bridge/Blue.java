package 单一职责.bridge;

class Blue implements Color {
    @Override
    public void draw() {
        System.out.println("Blue.draw");
    }
}
