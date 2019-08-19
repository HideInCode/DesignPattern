package 结构型模式.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectHandler implements InvocationHandler {
    
    private Object realSubject;
    
    /**
     * 一般都会给个构造器,穿入要处理的真实主体
     *
     * @param realSubject 真实角色
     */
    public SubjectHandler(Object realSubject) {
        this.realSubject = realSubject;
    }
    
    /**
     * jdk 的动态代理核心在于实现这个方法，由反射来调用
     *
     * @param proxy  最后生成的代理
     * @param method 调用接口的函数
     * @param args   函数参数
     * @return 函数返回值
     * @throws Throwable 抛异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        //java.lang.reflect.Proxy.ProxyBuilder.proxyClassNamePrefix="$Proxy"
        //反射生成的代理对象都会以$Proxy开头
        System.out.println(proxy.getClass().getSimpleName());
        if (proxy.getClass().getSimpleName().contains("$Proxy")) {
            System.out.println("生成了代理对象");
        }
        return method.invoke(realSubject, args);
    }
}
