package com.qfedu.test;

import com.qfedu.common.util.ShiroEncryUtil;

/**
 *@Author feri
 *@Date Created in 2018/8/14 09:28
 */
public class Pass_Main {
    public static void main(String[] args) {

        //8c8f04d0f092abaa2e3c04dcfec05c59
        System.out.println("qfjava:"+ShiroEncryUtil.md5("qfjava"));
        //7ca46aba60cf7e39510c3a7898012c68
        System.out.println("123456:"+ShiroEncryUtil.md5("123456"));
    }
}
