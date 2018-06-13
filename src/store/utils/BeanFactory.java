package store.utils;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class BeanFactory {
	@SuppressWarnings("unchecked")
	public static Object createObject(String name) {
		try {
			SAXReader read=new SAXReader();
			Document doc = read.read(BeanFactory.class.getClassLoader().getResourceAsStream("application.xml"));

			Element root=doc.getRootElement();
			List<Element> list=root.elements();
			for(Element ele:list){
				String id=ele.attributeValue("id");
				if(name.equals(id)){
					String str=ele.attributeValue("class");
					//将str中存放的全路径代表的字节码文件加载到内存
					Class clazz=Class.forName(str);
					return clazz.newInstance();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
