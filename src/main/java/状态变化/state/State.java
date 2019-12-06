package 状态变化.state;

//状态对应的操作抽象出来
interface State {
    //根据上下文修改状态
    void doSth(Context context);
}
