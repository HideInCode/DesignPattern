package 行为型模式;

/**
 * 为什么:把行为请求者和处理者解耦.不同于责任链,没有过多的过滤层次.
 * 使用场景:撤销和恢复功能,事务,点击按钮
 * 怎么做:把请求变成命令对象;
 * 方便对命令进行了扩展,对多个命令统一控制.
 */


abstract class Receiver {
    abstract void doSomething();
}

class ConcreteReceiver1 extends Receiver {
    void doSomething() {

    }
}
class ConcreteReceiver2 extends Receiver {
    void doSomething() {

    }
}


abstract class Commond {
    //指定接受者处理
    protected Receiver receiver;

    protected abstract void excuteCmd();
}


class Cmd1 extends Commond {

    public Cmd1(Receiver receiver) {
        this.receiver = receiver;
    }

    protected void excuteCmd() {
        receiver.doSomething();
    }
}

class Cmd2 extends Commond {
    public Cmd2(Receiver receiver) {
        this.receiver = receiver;
    }

    protected void excuteCmd() {
        receiver.doSomething();
    }
}

class Invoker {
    private Commond commond;

    public Invoker(Commond commond) {
        this.commond = commond;
    }

    public void action() {
        commond.excuteCmd();
    }
}


public class CommandDemo {
    public static void main(String[] args) {
        Receiver receiver = new ConcreteReceiver1();
        Commond commond = new Cmd1(receiver);

        Invoker invoker = new Invoker(commond);
    }
}
