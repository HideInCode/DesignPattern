package 行为变化.command;


public class CommandDemo {
    public static void main(String[] args) {
        Receiver receiver = new ConcreteReceiver1();
        Commond commond = new Cmd1(receiver);

        Invoker invoker = new Invoker(commond);
    }
}
