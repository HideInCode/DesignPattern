package 对象性能.singleton;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 单例
 * 注意事项:多线程时是否能正确获得对象;是否每次都创建对象浪费资源;反序列化不会生成新对象;
 * 简单的懒汉,饿汉就不讲了,因为线程不安全,加锁性能低.不在乎性能可以用synchronize+懒汉式;
 * 1.double-check-locking
 * 2.静态内部类
 * 3.枚举
 */
public class Singleton {
    public static void main(String[] args) {
        SingleInstance instance = SingleInstance.INSTANCE;
        SingleInstance instance1 = SingleInstance.INSTANCE;
        System.out.println(instance == instance1);
        instance.dosome();
        
        StaticInnerClazz instance2 = StaticInnerClazz.getInstance();
        StaticInnerClazz instance3 = StaticInnerClazz.getInstance();
        
        System.out.println(instance2 == instance3);
        
        Map<Integer, Object> map = new ConcurrentHashMap<>();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                
                map.put(i, StaticInnerClazz.getInstance());
            }
        }).start();
        
        //main线程比添加线程执行的要快,所以停顿1秒进行添加.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
