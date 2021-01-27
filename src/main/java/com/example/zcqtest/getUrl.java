package com.example.zcqtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getUrl {
    public String sendGet(String httpurl) throws IOException {
        URL url = new URL(httpurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置连接方式
        conn.setRequestMethod("GET");
        //设置主机连接时间超时时间3000毫秒
        conn.setConnectTimeout(3000);
        //设置读取远程返回数据的时间3000毫秒
        conn.setReadTimeout(3000);

        //发送请求
        conn.connect();
        //获取输入流
        InputStream is = conn.getInputStream();
        //封装输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        //接收读取数据
        StringBuffer sb = new StringBuffer();

        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\r\n");
        }
        if (null != br) {
            br.close();
        }
        if (null != is) {
            is.close();
        }
        //关闭连接
        conn.disconnect();
        return sb.toString();


    }
}
