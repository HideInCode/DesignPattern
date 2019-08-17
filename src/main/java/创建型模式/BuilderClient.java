package 创建型模式;

/**
 * 组装顺序不同引起的差异
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

class A {

}

class B {
}


class Drector {
    private Builder builder = new Builder();
    
    public void contract() {
        builder.createB();
        builder.createA();
    }
    
    public Product getProduct() {
        return builder.getProduct();
    }
}

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

public class BuilderClient {
    public static void main(String[] args) {
        Drector drector = new Drector();
        drector.contract();
        drector.getProduct();
    }
}