package 行为型模式.observerDP;

import java.util.Observable;
import java.util.Observer;

public class Ober implements Observer {
    
    public Ober(Observable o) {
        o.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ober find data is changed" + ((ToBeOb) o).getData());
    }
}
