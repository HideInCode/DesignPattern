package 数据结构.composite;

import java.util.LinkedList;
import java.util.List;

//树干
class Master implements Component {
    private String name;
    List<Component> list = new LinkedList<>();
    
    public Master(String name) {
        this.name = name;
    }
    
    public void add(Component component) {
        list.add(component);
    }
    
    public void remove(Component component) {
        list.remove(component);
    }
    
    
    public void process() {
        for (Component component : list) {
            component.process();
        }
    }
}
