package 结构型模式;

/**
 * 一个类存在两个维度的变化,如生产一个产品,既要有形状上的变化,又要有颜色上的变化.假定有3种颜色,4种形状.
 * 这时候直接继承会导致,1product->4shape->4*2color,要有13个类.为了一个颜色和一个形状搞了这么多类,不合理.
 * 这里说明继承就是乘法,组合就是做加法.
 * 所以要把一个产品从两个维度分开.分别实现,然后组合.
 * <p>
 * 这个模式和适配器模式很像,不同的是使用时的开发阶段;
 * 适配器,是对于已有接口的改造;
 * 桥是一开始就发现了存在多维度变化的类,
 */

abstract class Shape {
    
    //组合另一个维度的变化
    protected Color color;
    
    public Shape(Color color) {
        this.color = color;
    }
    
    abstract void createShape();
}

interface Color {
    void draw();
}


class Circle extends Shape {
    
    
    public Circle(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Circle.createShape");
    }
}

class Triangle extends Shape {
    public Triangle(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Triangle.createShape");
    }
}


class Square extends Shape {
    public Square(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Square.createShape");
    }
}

class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }
    
    @Override
    void createShape() {
        color.draw();
        System.out.println("Rectangle.createShape");
    }
}


class Red implements Color {
    @Override
    public void draw() {
        System.out.println("Red.draw");
    }
}

class Blue implements Color {
    @Override
    public void draw() {
        System.out.println("Blue.draw");
    }
}

class Yellow implements Color {
    @Override
    public void draw() {
        System.out.println("Yellow.draw");
    }
}


public class Bridge {
    public static void main(String[] args) {
        //任意组合
        Shape shape = new Rectangle(new Red());
        shape.createShape();
        
    }
}
