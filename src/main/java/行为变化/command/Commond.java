package 行为变化.command;

abstract class Commond {
    //指定接受者处理
    protected Receiver receiver;
    
    protected abstract void excuteCmd();
}
