package 结构型模式.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 改变了程序字节码的方式
 * cglib通过拦截调用的函数,对真实角色进行加强;
 * 步骤
 * 1.定义要代理的非final类,以及其实例inst
 * 2.Enhancer.create(inst.getClass(),无参数lambda)的结果转成真实类
 * 3.对于2中的lambda 使用method.invoke(真实对象实例,参数)得到返回值
 */
public class CglibClient {
    public static void main(String[] args) {
        CglibSubject inst = new CglibSubject();
    
        CglibSubject subject = (CglibSubject) Enhancer.create(inst.getClass(), (MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before");
            Object result = method.invoke(new CglibSubject(), objects);
            return result;
        });
        subject.doSome();
    
    }
    
}
