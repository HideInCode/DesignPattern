package 行为变化.command;

class Cmd1 extends Commond {
    
    public Cmd1(Receiver receiver) {
        this.receiver = receiver;
    }
    
    protected void excuteCmd() {
        receiver.doSomething();
    }
}
