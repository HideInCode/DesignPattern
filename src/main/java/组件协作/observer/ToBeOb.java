package 组件协作.observer;

import java.util.Observable;

/**
 * Observerable废弃的原因
 * 1.无法序列化
 * 2.非线程安全
 * 3.只能支持简单的变化通知,无法根据具体改变通知
 * 这里只做练习使用
 */
public class ToBeOb extends Observable {
    private int data;
    
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    
        //关键
        setChanged();
        notifyObservers();
    }
}
