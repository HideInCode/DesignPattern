package 典型模式;

/**
 * 是什么:状态设计模式,代码由于状态改变时,改变了对象的行为
 * 为什么:代码中包含大量与对象状态有关的条件语句,每次有新状态,又要修改代码,不符合开闭原则.
 * 怎么做:我们把状态的内容抽象出来,定义接口.利用多态的特性,有子类操作具体行为.
 * 新发现:和strategy模式很想,说明一般遇到多个ifelse就要想办法吧ifelse用接口的各个子类来替换
 */

//这些方法都在根据状态进行不同操作,我们按照结论里的把状态抽象出来
class BadCode {
    private String state;
    //其实用枚举更好,用的不熟先不搞.
    private static final String STATE_GOOD = "good";
    private static final String STATE_MID = "mid";
    private static final String STATE_BAD = "bad";

    public void fun1(String state) {
        if (state.equals(STATE_GOOD)) {
            System.out.println("good1");
            state = STATE_GOOD;
        } else if (state.equals(STATE_MID)) {
            System.out.println("mid1");
            state = STATE_MID;
        } else if (state.equals(STATE_BAD)) {
            System.out.println("bad1");
            state = STATE_BAD;
        }
    }

    public void fun2(String state) {

        if (state.equals(STATE_GOOD)) {
            System.out.println("good2");
            state = STATE_GOOD;

        } else if (state.equals(STATE_MID)) {
            System.out.println("mid2");
            state = STATE_MID;

        } else if (state.equals(STATE_BAD)) {
            System.out.println("bad2");
            state = STATE_BAD;

        }

    }
}

//抽象出状态的新的代码把操作(稳定)和状态(易变)分开
abstract class StationOper {

}

interface StateOperation {

    void fun1();

    void fun2();

    void fun3();
}

class Good implements StateOperation {
    String state;

    public void fun1() {
        System.out.println("good1");
        //修改状态
        state = "good";
    }

    public void fun2() {
        System.out.println("good2");
        state = "good";
    }

    public void fun3() {
        System.out.println("good3");
    }
}

class Bad implements StateOperation {
    public void fun1() {

    }

    public void fun2() {

    }

    public void fun3() {

    }
}

abstract class GoodCode {
    abstract void fun1();

    abstract void fun2();
}

public class StateDemo {
}
