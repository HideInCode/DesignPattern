package 状态变化.state;

//子类做两件事情:1.做具体某个状态下要做什么.2.修改当前状态
class StartState implements State {
    public void doSth(Context context) {
        System.out.println("start game");
        context.setState(this);
    }
    
    @Override
    public String toString() {
        return "start state";
    }
}
