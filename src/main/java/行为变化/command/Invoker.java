package 行为变化.command;

class Invoker {
    private Commond commond;
    
    public Invoker(Commond commond) {
        this.commond = commond;
    }
    
    public void action() {
        commond.excuteCmd();
    }
}
