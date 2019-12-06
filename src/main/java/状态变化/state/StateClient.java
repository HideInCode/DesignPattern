package 状态变化.state;


public class StateClient {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.getState());

        State state = new StartState();
        state.doSth(context);


        State endState = new EndState();
        endState.doSth(context);
    }
}
