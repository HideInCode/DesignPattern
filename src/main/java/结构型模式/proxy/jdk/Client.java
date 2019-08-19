package 结构型模式.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 动态代理解决了在运行时对对象的加强;
 * 一般步骤
 * 1.确定真实角色的行为,创建接口
 * 2.代理类实现InvocationHandler接口
 * 3.由Proxy.newProxyInstance生成新的代理
 */
public class Client {
    public static void main(String[] args) {
        CoderConsumer realSubject = new RealSubject();
        
        //Proxy.newProxyInstance 生成代理对象,
        CoderConsumer proxyCoder = (CoderConsumer) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                new Class[]{CoderConsumer.class}, new SubjectHandler(realSubject));
        proxyCoder.coding();
    }
}
