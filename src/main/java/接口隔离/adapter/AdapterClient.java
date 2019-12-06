package 接口隔离.adapter;

/**
 * 是什么:同时适配两个接口的转接器,例如java.util.Enumeration#asIterator()
 * 为什么:有些项目里的老接口不适用了,要搞个新接口,但又不能放弃老的接口.所以采取了adapter的折中思想
 * 怎么做:继承新的接口,引用老的接口.在使用时,把老接口放入适配器,生成新的接口
 * 顺便吐槽一句 runoob上的定义解释很好(估计也是抄书),但是例子给的总是让人莫名其妙.
 */
public class AdapterClient {
    public static void main(String[] args) {
        DestApi destApi = new Adapter(new SrcApiImpl());
    
        //实际上是原来的
        destApi.destMethod();
        
    }
}
