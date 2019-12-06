package 单一职责.bridge;

class Yellow implements Color {
    @Override
    public void draw() {
        System.out.println("Yellow.draw");
    }
}
