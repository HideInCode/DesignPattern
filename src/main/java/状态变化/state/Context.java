package 状态变化.state;

class Context {
    State state;
    
    public State getState() {
        return state;
    }
    
    public void setState(State state) {
        this.state = state;
    }
}
