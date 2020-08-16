package com.via.viapigeon.utils;


import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES工具
 */
public class AESUtils {


    /**
     * aes 加密
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String key) throws Exception {
        String fullAlg = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(fullAlg);
        IvParameterSpec iv = new IvParameterSpec(initIv(fullAlg));
        cipher.init(Cipher.ENCRYPT_MODE,
                new SecretKeySpec(key.getBytes(), "AES"),
                iv);

        byte[] encryptBytes = cipher.doFinal(content.getBytes("UTF-8"));
        return Base64Utils.encodeByte(encryptBytes);
    }


    /**
     * 初始向量的方法, 全部为0. 这里的写法适合于其它算法,针对AES算法的话,IV值一定是128位的(16字节).
     *
     * @param fullAlg
     * @return
     * @throws GeneralSecurityException
     */
    private static byte[] initIv(String fullAlg) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(fullAlg);
        int blockSize = cipher.getBlockSize();
        byte[] iv = new byte[blockSize];
        for (int i = 0; i < blockSize; ++i) {
            iv[i] = 0;
        }

        return iv;
    }


    /**
     * @param content 密文
     * @param key aes密钥
     * @return 原文
     */
    public static String decrypt(String content, String key)  {

        //反序列化AES密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");


        //128bit全零的IV向量
        byte[] iv = new byte[16];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = 0;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        //初始化加密器并加密
        try {
            Cipher deCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            deCipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
            byte[] encryptedBytes = Base64Utils.decodeByte(content);
            byte[] bytes = deCipher.doFinal(encryptedBytes);
            return new String(bytes);
        }catch (Exception e){
            System.out.print("**********decrypt**********"+e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("解密失败");
        }


    }



}
