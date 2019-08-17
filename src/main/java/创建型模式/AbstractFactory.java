package 创建型模式;

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

class MysqlFactory implements AbstractSqlFactory {
    public Conn getConn() {
        return new MysqlConn();
    }
    
    public Writer getWriter() {
        return new MysqlWriter();
    }
    
    public Reader getReader() {
        return new MysqlReader();
    }
}


class OracleFactory implements AbstractSqlFactory {
    public Conn getConn() {
        return new OracleConn();
    }
    
    public Writer getWriter() {
        return new OracleWriter();
    }
    
    public Reader getReader() {
        return new OracleReader();
    }
}

//每个家族都要做的产品
abstract class Conn {

}

abstract class Writer {

}

abstract class Reader {

}

//mysql family
class MysqlConn extends Conn {
}

class MysqlWriter extends Writer {
}

class MysqlReader extends Reader {

}

//oracle family
class OracleConn extends Conn {
}

class OracleWriter extends Writer {
}

class OracleReader extends Reader {

}


public class AbstractFactory {
    public static void main(String[] args) {
        AbstractSqlFactory abstractSqlFactory = new MysqlFactory();
        abstractSqlFactory.getWriter();
    
        AbstractSqlFactory factory = new OracleFactory();
        factory.getReader();
    }
}
