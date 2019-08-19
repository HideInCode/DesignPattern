package 结构型模式.proxy.cglib;

/**
 * cglib通过拦截调用的函数,对真实角色进行加强;
 * 可以在函数调用前做一些校验操作,相当于打开切面;
 * 对切面编程;
 */
public class CglibClient {
    public static void main(String[] args) {
        Object proxy = ProxyIntercepter.getProxy(new CglibSubject());
        if (proxy instanceof CglibSubject) {
            CglibSubject cglibSubject = (CglibSubject) proxy;
            cglibSubject.doSome();
        }
    }
}
