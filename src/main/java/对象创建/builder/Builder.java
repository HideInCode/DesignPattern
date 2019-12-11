package 对象创建.builder;

/**
 * 用来构建Product,一个Product由A,B两个组件构成
 * 如果只有一个实现类就不用直接拿Builder类当实现类用,参考StringBuilder
 * 如果有多个实现类,就把Builder设置为抽象类;
 */
public class Builder {
    
    private Product product = new Product();
    
    public void createA() {
        product.setPratA(new A());
    }
    
    public void createB() {
        product.setPartB(new B());
    }
    
    public Product getProduct() {
        return product;
    }
}
