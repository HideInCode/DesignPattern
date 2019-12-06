package 状态变化.memeton;

class Originator {
    
    //这个变量就是和备忘录联通的标志
    private String state;
    
    //存档
    public Memento save() {
        return new Memento(state);
    }
    
    //读档
    public void getMemento(Memento memento) {
        state = memento.getStete();
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
