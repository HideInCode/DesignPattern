package 行为变化.command;

class Cmd2 extends Commond {
    public Cmd2(Receiver receiver) {
        this.receiver = receiver;
    }
    
    protected void excuteCmd() {
        receiver.doSomething();
    }
}
