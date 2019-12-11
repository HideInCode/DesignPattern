package 对象创建.builder;

/**
 * 由两个组件构成的产品
 */
class Product {
    private A pratA;
    private B partB;
    
    public A getPratA() {
        return pratA;
    }
    
    public void setPratA(A pratA) {
        this.pratA = pratA;
    }
    
    public B getPartB() {
        return partB;
    }
    
    public void setPartB(B partB) {
        this.partB = partB;
    }
}
