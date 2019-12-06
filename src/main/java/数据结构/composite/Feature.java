package 数据结构.composite;

//树叶
class Feature implements Component {
    private String name;
    
    public Feature(String name) {
        this.name = name;
    }
    
    public void process() {
        System.out.println("Feature.process");
    }
}
