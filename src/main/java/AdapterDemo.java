/**
 * 是什么:同时适配两个接口
 * 为什么:有些项目里的老接口不适用了,要搞个新接口,但又不能放弃老的接口.所以采取了adapter的折中思想
 * 怎么做:继承新的接口,引用老的接口.在使用时,把老接口放入适配器,生成新的接口
 * 顺便吐槽一句 runoob上的定义解释很好(估计也是抄书),但是例子给的总是让人莫名其妙.
 */
interface OldApi {
    void oldMethod();
}

interface NewApi {
    void newMethod();
}

class Adapter implements NewApi {
    private OldApi oldApi;

    //生成是适配器时,初始化老的接口变量;
    public Adapter(OldApi oldApi) {
        this.oldApi = oldApi;
    }

    public void newMethod() {
        //新的接口中对老的接口封装.这可比改老的接口高明多了.
        oldApi.oldMethod();
    }


}

class OldApiImpl implements OldApi {
    public void oldMethod() {
        System.out.println("old api impl");
    }
}


public class AdapterDemo {
    public static void main(String[] args) {
        //把老的接口放入适配器,让他看起来像个新接口
        OldApi oldApi = new OldApiImpl();

        //真是机智呢
        NewApi newApi = new Adapter(oldApi);
        newApi.newMethod();

    }
}
