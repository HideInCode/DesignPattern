package 接口隔离.adapter;

class Adapter implements DestApi {
    private SrcApi srcApi;
    
    //生成是适配器时,初始化老的接口变量;
    public Adapter(SrcApi srcApi) {
        this.srcApi = srcApi;
    }
    
    public void destMethod() {
        srcApi.srcMethod();
    }
    
    
}
