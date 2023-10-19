package test;

import java.security.MessageDigest;

/**
 * @Author: cxc
 * @CreateTime: 2023-04-13  09:41
 * @Description: TODO
 * @Version: 1.0
 */
public class Md5Test {
    public static void main(String[] args) throws Exception {
        System.out.println(getMD5("211281199908232013"));
    }
    /**
     * 对字符串进行MD5加密(小写+字母)
     * @param encryptStr 要进行加密的字符串
     * @return 返回MD5加密后的字符串
     */
    public static String getMD5(String encryptStr) throws Exception {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(encryptStr.getBytes("UTF-8"));
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            encryptStr = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptStr;
    }
}
