package 接口隔离.proxy;

/**
 * 最基本的静态代理
 * 使用场景:隔离请求与真实角色
 */


/**
 * 两者都要遵循的行为
 */
interface IDo {
    void doSome();
}

//真的
class RealSubject implements IDo {
    @Override
    public void doSome() {
        System.out.println("RealSubject.doSome");
    }
}

//代理
class Proxy implements IDo {
    private RealSubject subject;
    
    public Proxy(RealSubject subject) {
        this.subject = subject;
    }
    
    @Override
    public void doSome() {
        subject.doSome();
    }
}

public class ProxyClient {
    
    public static void main(String[] args) {
        IDo d = new Proxy(new RealSubject());
        d.doSome();
    }
}
