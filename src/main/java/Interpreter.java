import java.util.HashMap;
import java.util.Map;

/**
 * 使用场景:业务频繁变化,类似结构重复出现,很容易把这些变化变成语法规则(简单的)
 * 构建语法树，定义终结符与非终结符。
 * 构建环境类，包含解释器之外的一些全局信息，一般是 HashMap。
 * 应用实例：编译器、运算表达式计算。
 * 可利用场景比较少，JAVA 中如果碰到可以用 expression4J 代替。
 * 这可能就是编译原理的一些操作吧
 */
interface Expression {
    int interpreter(Context context);
}


//这个类就是用来共享变量的,全局变量的封装方式学到了
abstract class NoTerminal implements Expression {
    protected Expression e1, e2;

    public NoTerminal(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}

class Minus extends NoTerminal {

    //注意这些变量,这个类也是集成Expression接口,同时组合了接口引用,这种同时具有is-a和has-a的情况,具有迭代的性质.
    //就是说旧的对象可以作为新的对象的变量
    public Minus(Expression e1, Expression e2) {
        super(e1, e2);
    }


    public int interpreter(Context context) {
        return this.e1.interpreter(context) - this.e2.interpreter(context);
    }
}

class Plus extends NoTerminal {


    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    public int interpreter(Context context) {
        return this.e1.interpreter(context) + this.e2.interpreter(context);
    }
}


class Terminal implements Expression {

    private String var;

    public Terminal(String var) {
        this.var = var;
    }

    //terminal的对象最终要从这里获取值
    public int interpreter(Context context) {
        return context.lookup(this);
    }
}


class Context {
    private Map<Expression, Integer> map = new HashMap<Expression, Integer>();

    public void add(Expression expression, Integer value) {
        map.put(expression, value);
    }

    public int lookup(Expression expression) {
        return map.get(expression);
    }
}

public class Interpreter {
    public static void main(String[] args) {
        Context context = new Context();
        Terminal a = new Terminal("a");
        Terminal b = new Terminal("b");
        Terminal c = new Terminal("c");


        context.add(a, 4);
        context.add(b, 8);
        context.add(c, 2);


        //注意这些变量是共享的,对于plus和minus来说
        Plus plus = new Plus(a, b);
        Minus minus = new Minus(plus, c);

        //这里是重点,minus调用解析,解析
        int result = minus.interpreter(context);
        System.out.println(result);

    }
}
