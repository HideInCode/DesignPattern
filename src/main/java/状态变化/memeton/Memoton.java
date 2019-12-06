package 状态变化.memeton;
/**
 * 这个有意思:事务回滚,游戏存档,ctrl+z
 * 但是java可以用对象序列化,更加简单的实现.
 */


/**
 * 是什么:备忘录模式,所谓备忘录模式就是在不破坏封装的前提下，
 * 捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态。
 * 为什么:记录一个对象的内部状态，这样做的目的就是为了允许用户取消不确定或者错误的操作，能够恢复到他原先的状态，
 * 使得他有"后悔药"可吃。
 * 怎么做:通过一个备忘录类专门存储对象状态。
 */
public class Memoton {
    
    public static void main(String[] args) {
        
        //对同一个对象,有多个新存档,放入同一个容器中.
        Originator originator = new Originator();
        originator.setState("第一关");
        Memento save = originator.save();
        CareTaker careTaker = new CareTaker();
        careTaker.addMemento(save);
        originator.setState("第二关");
        originator.setState("第三关");
        careTaker.addMemento(originator.save());
        originator.setState("第四关");
        careTaker.addMemento(originator.save());

        System.out.println(originator.getState());

        //使用读档技能
        originator.getMemento(careTaker.get(1));
        //
        System.out.println(originator.getState());
    }
}
