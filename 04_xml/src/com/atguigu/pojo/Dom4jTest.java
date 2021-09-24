package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;


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
}
