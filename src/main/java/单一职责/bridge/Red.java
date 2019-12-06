package 单一职责.bridge;

class Red implements Color {
    @Override
    public void draw() {
        System.out.println("Red.draw");
    }
}
