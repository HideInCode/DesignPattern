package 单一职责.decorator;

//具体可以被装饰的类
class RedKabda extends Kabda {
    @Override
    void change() {
        
        System.out.println("红色机器人卡布达...");
    }
}
