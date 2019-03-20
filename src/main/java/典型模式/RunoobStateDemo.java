package 典型模式;


//状态对应的操作抽象出来
interface State {
    //根据上下文修改状态
    void doSth(Context context);
}

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

class EndState implements State {
    public void doSth(Context context) {
        System.out.println("ganme over");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "end state";
    }
}



class Context {
    State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

public class RunoobStateDemo {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.getState());

        State state = new StartState();
        state.doSth(context);


        State endState = new EndState();
        endState.doSth(context);
    }
}
