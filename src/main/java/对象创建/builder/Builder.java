package 对象创建.builder;

class Builder {
    
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
