package 结构型模式;

/**
 * 如果一个类拓展时导致子类过分的多,A[1,2,3]->B[1,2,3]->C[1,2,3] 类C爆炸;考虑把子类C抽象成装饰者Decorator;
 * 这个装饰者即是一个A,也含有A的引用(一般看到is-a,has-a出现基本都是装饰者);
 * 这样就可以动态的为初始父类添加职责了,装饰了原始父类,也没有改变父类的结构.
 * <p>
 * <p>
 * <p>
 * 具体参考 FilterInputStream BufferedReader FilterReader
 * 以FilterInputStream为例:
 * 继承了InputStream 含有InputStream引用
 * 其子类BufferedInputStream可以修饰InputStream的子类,如FileInputStream
 * 所有就有了常见的 InputStream in = new BufferedInputStream(new FileInputStream(""));
 */

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

//具体可以被装饰的类
class RedKabda extends Kabda {
    @Override
    void change() {
        
        System.out.println("红色机器人卡布达...");
    }
}

/**
 * 装饰者:
 * 即是一个kabda类型,又有kabda功能;
 */
class KabdaDecrator extends Kabda {
    private Kabda kabda;
    
    public KabdaDecrator(Kabda kabda) {
        this.kabda = kabda;
    }
    
    @Override
    void change() {
        kabda.change();
    }
}


//用来装饰的具体类
class Superform extends KabdaDecrator {
    public Superform(Kabda kabda) {
        super(kabda);
    }
    
    @Override
    void change() {
        super.change();
        decorateFun();
    }
    
    private void decorateFun() {
        System.out.println("超级变换形态...");
    }
}

public class Decorator {
    public static void main(String[] args) {
        Kabda kabda = new Superform(new RedKabda());
        kabda.change();
        
    }
}
