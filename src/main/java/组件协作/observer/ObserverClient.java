package 组件协作.observer;

public class ObserverClient {
    public static void main(String[] args) {
        ToBeOb toBeOb = new ToBeOb();
        Ob ober = new Ob(toBeOb);
        toBeOb.setData(5);
        toBeOb.setData(6);
    }
}
