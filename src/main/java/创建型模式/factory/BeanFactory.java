package 创建型模式.factory;

import 创建型模式.Prototype.Student;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * 创建对象,利用ioc思想
 * 模仿spring的bean工厂,加上反射创建一个对象.
 * 解决接口选择问题
 */
public class BeanFactory {
    
    public static Object getBeanById(String id) {
        Set<Bean> beans = XmlParser.getBeans();
        for (Bean bean : beans) {
            if (id.equals(bean.getId())) {
                return createObject(bean);
            }
        }
        return null;
    }
    
    private static Object createObject(Bean bean) {
        Object newInstance = null;
        try {
            
            Class<?> clazz = Class.forName(bean.getName());
            newInstance = clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        
        return newInstance;
    }
    
    public static void main(String[] args) {
        Object obj = getBeanById("student");
        if (obj instanceof Student) {
            Student student = (Student) obj;
            student.setId(1);
            System.out.println(student.getId());
        }
    }
}

