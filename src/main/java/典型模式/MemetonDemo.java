package 典型模式;
/**
 * 这个有意思:事务回滚,游戏存档,ctrl+z
 * 但是java可以用对象序列化,更加简单的实现.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 是什么:备忘录模式,所谓备忘录模式就是在不破坏封装的前提下，
 * 捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态。
 * 为什么:记录一个对象的内部状态，这样做的目的就是为了允许用户取消不确定或者错误的操作，能够恢复到他原先的状态，
 * 使得他有"后悔药"可吃。
 * 怎么做:通过一个备忘录类专门存储对象状态。
 */

//一个简单的bean,和要保存的对象一一映射.隐藏originator的信息隐藏.
class Memento {
    private String stete;

    public Memento(String stete) {
        this.stete = stete;
    }

    public String getStete() {
        return stete;
    }

    public void setStete(String stete) {
        this.stete = stete;
    }
}

//有个档案员,专门管控多个存档
class CareTaker {
    List<Memento> list = new ArrayList<Memento>();

    public void addMemento(Memento memento) {
        list.add(memento);
    }


    //读取某个存档点
    public Memento get(int index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Memento memento : list) {
            stringBuilder.append(memento.getStete());
        }
        return stringBuilder.toString();
    }
}

class Originator {

    //这个变量就是和备忘录联通的标志
    private String state;

    //存档
    public Memento save() {
        return new Memento(state);
    }

    //读档
    public void getMemento(Memento memento) {
        state = memento.getStete();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


public class MemetonDemo {

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
