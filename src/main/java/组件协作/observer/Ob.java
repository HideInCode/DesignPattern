package 组件协作.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者,会被通知
 */
public class Ob implements Observer {
    
    public Ob(Observable o) {
        o.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ober find data is changed" + ((ToBeOb) o).getData());
    }
}
