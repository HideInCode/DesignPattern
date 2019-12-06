package 对象创建.abstractFactory;

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
