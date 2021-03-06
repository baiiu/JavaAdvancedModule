package com.example;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import static com.example.HexString.hexStringToBytes;

/**
 * http://www.convertstring.com/zh_CN
 * <p>
 * http://tool.chinaz.com/Tools/Unicode.aspx
 * <p>
 * https://github.com/apache/commons-lang/blob/master/src/main/java/org/apache/commons/lang3/StringEscapeUtils.java
 */
public class TestCharset {

    public static void main(String[] args) throws UnsupportedEncodingException {
        /*
            {
              "code": 0,
              "data": [
                "1",
                "'sss中'",
                "%7b%22code%22%3a%22%27a%27%22%7d"
              ],
              "msg": "操作成功"
            }
         */
        String s = "{\"code\": 0,\"data\":[\"1\",\"'sss'\",\"%7b%22code%22%3a%22%27a%27%22%7d\"],\"msg\": \"操作成功\"}";
        System.out.println(s);

        for (int i = 0; i < 2; ++i) {
            s = URLEncoder.encode(s);
        }


//        for (int i = 0; i < 10; ++i) {
//            try {
//                parse = JSON.parse(s);
//                break;
//            } catch (Exception e) {
//                s = URLDecoder.decode(s);
//                System.out.println(e.toString());
//            }
//        }
//        if (parse == null) {
//            System.out.println("error");
//        }
//
//        System.out.println(String.valueOf(parse));

        Object parse = null;
        for (int i = 0; i < 5; i++) {
            s = URLDecoder.decode(s);
            try {
                parse = JSON.parse(s);
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        if (parse == null) {
            System.out.println("error");
        }
        System.out.println(String.valueOf(parse));



//        do {
//            try {
//                parse = JSON.parse(s);
//                break;
//            } catch (Exception e) {
//                s = URLDecoder.decode(s);
//            }
//
//        } while (true);
    }

    private static void test(String s) {

        System.out.println("--------------------------");

        // unicode
        String unicode = Unicode.toUnicode(s);
        System.out.println(unicode);
        System.out.println(Unicode.decodeUnicode(unicode));

        System.out.println("--------------------------");

        // urlencoder
        String encode = URLEncoder.encode(s);
        System.out.println(encode);
        System.out.println(URLDecoder.decode(encode));
        encode = URLEncoder.encode(encode);
        System.out.println(encode);
        System.out.println(URLDecoder.decode(URLDecoder.decode(encode)));

        System.out.println("--------------------------");

        // 16进制字符串
        String bytesToHexString = HexString.bytesToHexString(s);
        System.out.println(bytesToHexString);
//        bytesToHexString = HexString.bytesToHexString(bytesToHexString);
//        System.out.println(bytesToHexString);
        System.out.println(URLEncoder.encode(s));
        System.out.println(hexStringToBytes(bytesToHexString));


        // 霍夫曼编码、减小体积

    }


}
