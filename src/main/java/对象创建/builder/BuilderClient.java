package 对象创建.builder;


/**
 * 组装顺序不同引起的差异
 * 参考StringBuilder 中的append,即时是append不同类型,也会返回相同的对象;
 * 这样就不会对外公开对象生成细节;
 */
public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director();
        director.contract();
        director.getProduct();
    }
}