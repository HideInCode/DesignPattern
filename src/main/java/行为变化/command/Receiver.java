package 行为变化.command;

/**
 * 为什么:把行为请求者和处理者解耦.不同于责任链,没有过多的过滤层次.
 * 使用场景:撤销和恢复功能,事务,点击按钮
 * 怎么做:把请求变成命令对象;
 * 方便对命令进行了扩展,对多个命令统一控制.
 */


abstract class Receiver {
    abstract void doSomething();
}
