import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.*;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;


public class document {

    public static void main(String[] args)  {
//        创建SAX解析器, 创建一个SAXReader 输入流，去读取xml配置文件
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
//         读取xml数据，返回文档对象, 就是生成document对象
             document = saxReader.read("D:\\panjianminbiancheng\\aaa\\jiexixml\\src\\books.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // 1  读取books.xml文件
        //2   通过document对象获取根元素
        //3   通过根元素获取book对象
        assert document != null;
        // 通过文档对象，获取文档的根元素
        Element rootElement = document.getRootElement();  // 获取xml的根元素
//        System.out.println(element);
//       3.通过根元素获取后面元素标签对象
//        element()和elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");

        //4  遍历处理每个book标签转换为Book类
        for (Element book: books) {
            // asXML()  是把标签对象，转化为标签字符串
//            System.out.println(book.asXML());
            Element nameElement = book.element("name");
//            getText()   表示获取标签中的文本内容
            String nameText = nameElement.getText();
//            elementText()  表示直接获取对应的标签里面的文本内容
            String priceText = book.elementText("price");

            String authorText = book.elementText("author");
//                attributeValue()  表示获取属性值， attribute 属性   value值
            String sn = book.attributeValue("id");

            Book book1 = new Book(sn, nameText, authorText, priceText);

            System.out.println(book1.toString());

        }





    }






}
