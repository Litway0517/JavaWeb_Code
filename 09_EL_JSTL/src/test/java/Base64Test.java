import org.junit.jupiter.api.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Base64Test {


    @Test
    public void testBase64() throws Exception {

        String content = "我爱你";

        // base64的编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();

        // 执行编码操作 -> 5oiR54ix5L2g
        String encodeString = base64Encoder.encode(content.getBytes("UTF-8"));
        System.out.println("编码之后的内容 -> " + encodeString);


        // 创建base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();

        // 执行解码操作
        byte[] bytes = base64Decoder.decodeBuffer(encodeString);
        String str = new String(bytes, 0, bytes.length);
        System.out.println("解码之后的内容 -> " + str);


    }




}
