package 对象性能.singleton;

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
