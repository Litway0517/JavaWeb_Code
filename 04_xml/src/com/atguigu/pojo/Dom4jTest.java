package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;


public class Dom4jTest {

    @Test
    public void test1() {

        // 首先, 创建一个SaxReader对象输入流, 去读取XML文件
        SAXReader saxReader = new SAXReader();
        // 读取源文件, 并生成document对象
        Document document = null;
        try {
            document = saxReader.read("src/books.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // 输出
        System.out.println(document);

    }


    @Test
    public void test2() {
        /*
            - 读取books.xml文件
            - 在Junit测试中, 相对路径是从模块名开始计算的
            - 通过Document对象获取根元素
            - 通过根元素获取book标签对象
            - 遍历, 处理每个book标签转换为Book类
         */

        // 创建SAXReader对象读取
        SAXReader saxReader = new SAXReader();
        try {
            // 读取源文件
            Document document = saxReader.read("src/books.xml");
            // 通过根元素获取book标签对象
            Element rootElement = document.getRootElement();
            // System.out.println(rootElement);

            // element和elements都是获取根元素的子元素, 需要传入标签名
            List<Element> books = rootElement.elements("book");
            // 遍历, 处理每个book标签转换为Book类
            for (Element book : books) {
                // asXML() : 把标签对象转换为标签字符串
//                System.out.println(book.asXML());

                // 获取子标签的子标签也是使用element函数
                Element nameElement = book.element("name");
                System.out.println(nameElement.asXML());

                // getText()方法, 是获取标签中的文本内容
                /*
                    先获取根节点 -> 再用根节点获取其他节点(需要指出节点名称) -> 在根据需要获取name级别的节点 -> 对name节点使用getText方法.
                 */
                String nameText = nameElement.getText();
                System.out.println("书名: " + nameText);

                // elementText("指定标签名"), 可以直接获取指定标签名的标签内的文本
                String priceText = book.elementText("price");
//                System.out.println("价格: " + priceText);

                String authorText = book.elementText("author");
//                System.out.println(authorText);

                String sn = book.attributeValue("sn");

                // 创建一个Book对象(构造方法)
                // 直接输出是因为冲洗呃呃Book的toString方法
                System.out.println("构造新的Book对象: " + new Book(sn, nameText, Double.parseDouble(priceText), authorText));


            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }


}
