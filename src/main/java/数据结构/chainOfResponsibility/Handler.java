package 数据结构.chainOfResponsibility;

//就是个链表,注意继承表示is-a关系
abstract class Handler {
    public static final int DEBUG = 0;
    public static final int WARN = 1;
    public static final int ERROR = 2;
    
    //子类共有
    protected int level;
    protected Handler nextHandler;
    
    protected void setNext(Handler handler) {
        this.nextHandler = handler;
    }
    
    private void processMessage(int level) {
        switch (level) {
            case 0:
                System.out.println("debug");
                break;
            case 1:
                System.out.println("warn");
                break;
            case 2:
                System.out.println("error");
                break;
        }
    }
    
    void hanleProblem(int level) {
        if (this.level < level) {
            processMessage(this.level);
        }
        if (nextHandler != null) {
            nextHandler.hanleProblem(level);
        }
    }
}
