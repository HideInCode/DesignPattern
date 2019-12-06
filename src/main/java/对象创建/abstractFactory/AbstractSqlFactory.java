package 对象创建.abstractFactory;

/**
 * 抽象工厂模式,封装了工厂的类;要求工厂是同一个系列,不同品牌.
 * 解决在一个产品族里面，定义多个产品。
 * mysql,Oracle都需要连接,读,写功能;不同的厂商有不同的实现方式.
 */

//同样是生产产品,要求实现类必须是同一族.
interface AbstractSqlFactory {
    Conn getConn();
    
    Writer getWriter();
    
    Reader getReader();
}
