package 单一职责.decorator;

/**
 * 卡布达变身
 * 1.划分模块:原始的kabda
 * 2.变身的装饰者:Changer
 * 3.具体变换的形态
 */

//需要被装饰的类型
abstract class Kabda {
    abstract void change();
    
}
