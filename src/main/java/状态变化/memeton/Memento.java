package 状态变化.memeton;

//一个简单的bean,和要保存的对象一一映射.隐藏originator的信息隐藏.
class Memento {
    private String stete;
    
    public Memento(String stete) {
        this.stete = stete;
    }
    
    public String getStete() {
        return stete;
    }
    
    public void setStete(String stete) {
        this.stete = stete;
    }
}
