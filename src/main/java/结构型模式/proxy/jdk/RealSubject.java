package 结构型模式.proxy.jdk;

public class RealSubject implements RealSubInterface {
    @Override
    public void coding() {
        System.out.println("I am coding");
    }
}
