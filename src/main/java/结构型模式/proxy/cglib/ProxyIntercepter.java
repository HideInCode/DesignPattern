package 结构型模式.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 做拦截
 */
public class ProxyIntercepter implements MethodInterceptor {
    private Object object;
    
    public ProxyIntercepter(Object object) {
        this.object = object;
    }
    
    public static Object getProxy(Object object) {
        
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new ProxyIntercepter(object));
        enhancer.setSuperclass(object.getClass());
        
        return enhancer.create();
    }
    
    private void before() {
        System.out.println("ProxyIntercepter.before");
    }
    
    private void after() {
        System.out.println("ProxyIntercepter.after");
    }
    
    /**
     * 拦截函数调用,把真实类当做父类来拦截;
     *
     * @param o           由CGLib动态生成的代理类实例
     * @param method      要被拦截的方法
     * @param objects     拦截方法的参数
     * @param methodProxy 生成的代理类对代理方法的引用
     * @return 函数执行的结果
     * @throws Throwable 异常或者错误
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        //这里要用传进来的真实对象调用,
        //Object result = method.invoke(object, objects);
        //也可以由代理来调用
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }
}
