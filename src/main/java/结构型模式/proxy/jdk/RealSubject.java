package 结构型模式.proxy.jdk;

public class RealSubject implements CoderConsumer {
    
    
    @Override
    public void coding() {
        System.out.println("I am coding");
    }
}
