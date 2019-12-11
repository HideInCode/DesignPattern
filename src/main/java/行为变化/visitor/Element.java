package 行为变化.visitor;

//重点就是确保这个类有几个子类,预留个扩展接口
abstract class Element {
    //预留接口 传入访问者,把具体子类吐出去
    public abstract void acceptVisitor(Visitor visitor);
}
