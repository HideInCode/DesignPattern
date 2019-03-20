/**
 * 工厂方法是生产单个对象的模式
 * 抽象工厂是生产一个家族的相关联产品,抽象工厂的子类来产生具体的对象
 * 顺便吐槽下,python不适合设计模式
 */

/**
 * 解决一系列全家桶,不同家族的问题
 * 这里以sql为例,每种数据库都有连接,输入sql,读数据功能.但是不同的品牌功能有不太一样,我们要用不同的产品,就要分类.
 */

//每个家族都有的产品
class Conn {

}

class Comm {

}

class Reader {

}

abstract class AbstractSqlFactory {
    abstract Conn getConn();

    abstract Comm getComm();

    abstract Reader getReader();
}

//mysql family
class MysqlConn extends Conn {
}

class MysqlComm extends Comm {
}

class MysqlReader extends Reader {

}

//oracle
class OracleConn extends Conn {
}

class OracleComm extends Comm {
}

class OracleReader extends Reader {

}


class MysqlFactory extends AbstractSqlFactory {
    Conn getConn() {
        return new MysqlConn();
    }

    Comm getComm() {
        return new MysqlComm();
    }

    Reader getReader() {
        return new MysqlReader();
    }
}


class OracleFactory extends AbstractSqlFactory {
    Conn getConn() {
        return new OracleConn();
    }

    Comm getComm() {
        return new OracleComm();
    }

    Reader getReader() {
        return new OracleReader();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractSqlFactory abstractSqlFactory = new MysqlFactory();
        Comm comm = abstractSqlFactory.getComm();
        System.out.println(comm);
    }
}
