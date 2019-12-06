package 单一职责.decorator;

/**
 * 装饰者:
 * 即是一个kabda类型,又有kabda功能;
 */
class KabdaDecrator extends Kabda {
    private Kabda kabda;
    
    public KabdaDecrator(Kabda kabda) {
        this.kabda = kabda;
    }
    
    @Override
    void change() {
        kabda.change();
    }
}
