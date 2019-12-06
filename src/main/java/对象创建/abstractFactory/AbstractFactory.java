package 对象创建.abstractFactory;


public class AbstractFactory {
    public static void main(String[] args) {
        AbstractSqlFactory abstractSqlFactory = new MysqlFactory();
        abstractSqlFactory.getWriter();
    
        AbstractSqlFactory factory = new OracleFactory();
        factory.getReader();
    }
}
