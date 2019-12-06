package 对象创建.builder;

//指导者
class Director {
    private Builder builder = new Builder();
    
    public void contract() {
        builder.createB();
        builder.createA();
    }
    
    public Product getProduct() {
        return builder.getProduct();
    }
}
