package 对象创建.factory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * 创建对象,利用ioc思想
 * 模仿spring的bean工厂,加上反射创建一个对象.
 * 解决接口选择问题
 */
public class BeanFactory {
    
    private static HashMap<String, Object> beans;
    
    static {
        beans = new HashMap<>();
        Document document = XmlUtil.getCfgDocument();
        if (document != null) {
            NodeList beansInXml = document.getElementsByTagName("bean");
            for (int i = 0; i < beansInXml.getLength(); i++) {
                Node item = beansInXml.item(i);
                NamedNodeMap attributes = item.getAttributes();
                Node id = attributes.getNamedItem("id");
                Node claz = attributes.getNamedItem("class");
                beans.put(id.getTextContent(), createObject(claz.getTextContent()));
            }
        }
    }
    
    public static Object getBeanById(String id) {
        return beans.get(id);
    }
    
    private static Object createObject(String qualifyName) {
        Object newInstance = null;
        try {
            
            Class<?> clazz = Class.forName(qualifyName);
            newInstance = clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        
        return newInstance;
    }
    
    public static void main(String[] args) {
        Object obj = getBeanById("student");
        Student student = (Student) obj;
        student.setId(1);
        System.out.println(student.getId());
    }
}

