package 创建型模式.factory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class XmlParser {
    
    private XmlParser() {
    
    }
    
    private static Document getDocument() {
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            String cfgXml = getCfgXml(".");
            if (cfgXml == null || "".equals(cfgXml)) {
                return document;
            }
            document = builder.parse(new File(cfgXml));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return document;
    }
    
    /**
     * 必须是当前项目下的context.xml
     *
     * @return 文件路径
     */
    private static String getCfgXml(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        String result = "";
        
        try {
            if (files != null) {
                for (File f : files) {
                    
                    if (f.isDirectory()) {
                        result = getCfgXml(f.getCanonicalPath());
                    }
                    
                    if (f.isFile()) {
                        result = f.getCanonicalPath();
                    }
                    if (result.endsWith("beans.xml")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static Set<Bean> getBeans() {
        Document document = getDocument();
        Set<Bean> set = new HashSet<>();
        if (document != null) {
            NodeList beans = document.getElementsByTagName("bean");
            for (int i = 0; i < beans.getLength(); i++) {
                Bean bean = new Bean();
                Node item = beans.item(i);
                NamedNodeMap attributes = item.getAttributes();
                Node id = attributes.getNamedItem("id");
                Node clazz = attributes.getNamedItem("class");
                bean.setId(id.getTextContent());
                bean.setName(clazz.getTextContent());
                set.add(bean);
            }
        }
        
        return set;
    }
    
    public static void main(String[] args) {
        Set<Bean> beans = getBeans();
        for (Bean bean : beans) {
            System.out.println(bean);
        }
    }
}
