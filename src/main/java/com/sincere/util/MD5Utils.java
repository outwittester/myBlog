package com.sincere.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * MD5加密类
     *
     * @param str 要加密的字符串
     * @return 加密后的字符串
     */
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


//    public static void main(String[] args) {
//        System.out.println(code("123"));
//        String s = "[{id=1, name=Fashion, description=Category for anything related to fashion., created=2014-06-01 00:35:07.0, modified=2014-05-30 17:34:33.0, datetime=null, text=null, timestamp=null}, {id=2, name=Electronics, description=Gadgets, drones and more., created=2014-06-01 00:35:07.0, modified=2014-05-30 17:34:33.0, datetime=null, text=null, timestamp=null}, {id=3, name=Motors, description=Motor sports and more, created=2014-06-01 00:35:07.0, modified=2014-05-30 17:34:54.0, datetime=null, text=null, timestamp=null}, {id=5, name=Movies, description=Movie products., created=0001-06-10 00:00:00.0, modified=2016-01-08 13:27:26.0, datetime=null, text=null, timestamp=null}, {id=6, name=Books, description=Kindle books, audio books and more., created=0001-06-01 00:00:00.0, modified=2016-01-08 13:27:47.0, datetime=null, text=null, timestamp=null}, {id=13, name=Sports, description=Drop into new winter gear., created=2016-01-09 02:24:24.0, modified=2016-01-09 01:24:24.0, datetime=null, text=null, timestamp=null}]";
//        s = s.replace("[", "{");
//        s = s.replace(']', '}');
//        System.out.println(s);
//    }
}
