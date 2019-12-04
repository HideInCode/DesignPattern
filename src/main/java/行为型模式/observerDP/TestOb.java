package 行为型模式.observerDP;

public class TestOb {
    public static void main(String[] args) {
        ToBeOb toBeOb = new ToBeOb();
        Ober ober = new Ober(toBeOb);
        toBeOb.setData(5);
        toBeOb.setData(6);
    }
}
