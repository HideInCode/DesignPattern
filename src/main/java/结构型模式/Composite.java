package 结构型模式;

import java.util.LinkedList;
import java.util.List;

/**
 * 是什么:组合模式,用树形结构的树枝树叶把复杂对象和简单对象分看
 * 为什么:
 * 它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，如同java中文件与文件夹
 * 客户程序可以向处理简单元素一样来处理复杂元素，从而使得客户程序与复杂元素的内部结构解耦。
 * 使用场景:
 * 1、您想表示对象的部分-整体层次结构（树形结构）。
 * 2、您希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
 * 怎么做:树枝和叶子实现统一接口，树枝内部组合该接口。
 */

interface Component {
    void process();
}

//树干
class Master implements Component {
    private String name;
    List<Component> list = new LinkedList<Component>();
    
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

//树叶
class Feature implements Component {
    private String name;
    
    public Feature(String name) {
        this.name = name;
    }
    
    public void process() {
        System.out.println("Feature.process");
    }
}


public class Composite {
    public static void main(String[] args) {
        Master root = new Master("root");
        Master component1 = new Master("master1");
        Master component2 = new Master("master2");
        Master component3 = new Master("master3");
        Feature feature1 = new Feature("feature1");
        Feature feature2 = new Feature("feature2");
        
        
        //每一个composite中都有list可以add,所以可以搞很多个composite组合复杂的结构.
        root.add(component1);
        component1.add(component2);
        component2.add(feature1);
        
        root.add(component3);
        component3.add(feature2);
        root.process();
    }
    
    
}
