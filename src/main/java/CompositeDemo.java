import java.util.LinkedList;
import java.util.List;

/**
 * 是什么:组合模式,用树形结构的树枝树叶把复杂对象和简单对象分看
 * 为什么:
 * 它在我们树型结构的问题中，模糊了简单元素和复杂元素的概念，
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
class Composite implements Component {
    private String name;
    List<Component> list = new LinkedList<Component>();

    public Composite(String name) {
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
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    public void process() {
        System.out.println("leaf process");
    }
}


public class CompositeDemo {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        Composite component1 = new Composite("node1");
        Composite component2 = new Composite("node2");
        Composite component3 = new Composite("node3");
        Leaf leaf1 = new Leaf("leaf1");
        Leaf leaf2 = new Leaf("leaf2");


        //每一个composite中都有list可以add,所以可以搞很多个composite组合复杂的结构.
        root.add(component1);
        component1.add(component2);
        component2.add(leaf1);

        root.add(component3);
        root.process();
    }



}
