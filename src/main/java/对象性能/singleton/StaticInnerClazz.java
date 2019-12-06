package 对象性能.singleton;

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
