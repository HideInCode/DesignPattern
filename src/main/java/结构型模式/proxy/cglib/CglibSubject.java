package 结构型模式.proxy.cglib;

/**
 * cglib准备加强的类;
 * 无法对final类操作
 * aop面向切面编程的实现原理,其实就是在运行时拦截方法;
 * <p>
 * 当bean实现接口时，spring使用jdk动态代理
 * <p>
 * 当bean没实现接口，spring使用cglib
 * 详情见:DefaultAopProxyFactory
 */
public class CglibSubject {
    public void doSome() {
        System.out.println("CglibSubject.doSome");
    }
}
