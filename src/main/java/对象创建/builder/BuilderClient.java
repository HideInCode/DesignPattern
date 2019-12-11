package 对象创建.builder;


/**
 * 组装顺序不同引起的差异
 * 这样就不会对外公开对象生成细节;
 * 对于StringBuilder,其实就是对String的一个builder,由于只有一个实现类,这里的StringBuilder就不需要分成抽象类和具体的类,
 * 同时StringBuilder还扮演了Director的身份,
 * 通过重载append(各种类型),对String类型进行构建,为了链式调用,每次都返回自身.
 */
public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director();
        director.contract();
        
        //这就是产品
        Product product = director.getProduct();
    }
}