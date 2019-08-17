package 创建型模式;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 双重检查锁
 * 1.理解volatile的用途,禁止重排序
 * 2.立即每个not null拦截了什么
 * 3.有风险,不推荐.
 */
class DCL {
    private static volatile DCL instance;
    
    private DCL() {
    }
    
    public static DCL getInstance() {
        //第一次是为了不必要的同步,上锁很耗资源
        //两个线程同时访问,重排序后;在第二个还没有获得锁时,会认为instance已经指向了一块内存.然而这是个没有初始化的内存;
        if (instance == null) {
            synchronized (DCL.class) {
                //第二次,没有对象就创建
                if (instance == null) {
                    //理想顺序:1.分配内存 2.初始化对象 3.让instance指向新对象
                    instance = new DCL();
                }
            }
        }
        
        return instance;
    }
}


/**
 * 使用静态内部类存储实例;
 * 1.线程安全:虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步;
 * 如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，
 * 直到活动线程执行<clinit>()方法完毕。如果在一个类的<clinit>()方法中有耗时很长的操作，
 * 就可能造成多个进程阻塞(需要注意的是，其他线程虽然会被阻塞，但如果执行<clinit>()方法后，其他线程唤醒之后不会再次进入<clinit>()方法。
 * 同一个加载器下，一个类型只会初始化一次。)，在实际应用中，这种阻塞往往是很隐蔽的。
 * 2.节省空间:加载外部类时,内部类不会被加载.只有调用时才会加载
 */

class StaticInnerClazz {
    private StaticInnerClazz() {
    
    }
    
    private static class Holder {
        private static final StaticInnerClazz instance = new StaticInnerClazz();
    }
    
    public static StaticInnerClazz getInstance() {
        return Holder.instance;
    }
    
}


enum SingleInstance {
    INSTANCE;
    
    public void dosome() {
    }
    
}


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
