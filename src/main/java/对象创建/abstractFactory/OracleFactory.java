package 对象创建.abstractFactory;

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
