package 状态变化.state;

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
