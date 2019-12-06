package 行为变化.visitor;

//重点就是确保这个类有几个子类,预留个扩展接口
abstract class Element {
    //预留接口 用于添加新的功能
    public abstract void acceptVisitor(Visitor visitor);
}
