package 接口隔离.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * 动态代理解决了在运行时对对象的加强;
 * 1.确定真实对象,new 出实例inst
 * 2.由Proxy.newProxyInstance(inst.getClass().getClassLoader(),inst.getClass().getInterfaces(),lambda)生成的对象强转成真实对象
 * 3.2中的lambda使用method.invoke(inst,args)
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
    
        RealSubInterface subject = (RealSubInterface) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), (proxy, method, args1) -> {
            //在这里做增强处理
            System.out.println("before");
            return method.invoke(realSubject, args1);
        });
    
        subject.coding();
    }
}
