package 单一职责.decorator;

//用来装饰的具体类
class Superform extends KabdaDecrator {
    public Superform(Kabda kabda) {
        super(kabda);
    }
    
    @Override
    void change() {
        super.change();
        decorateFun();
    }
    
    private void decorateFun() {
        System.out.println("超级变换形态...");
    }
}
