package 状态变化.memeton;

import java.util.ArrayList;
import java.util.List;

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
