package example.controller;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class httpConnectionService {
    public String connectService(String url) throws IOException {
        StringBuffer buffer = new StringBuffer();
       try{ URL httpurl = new URL(url);
        //打开http连接
        HttpURLConnection httpUrlConn = (HttpURLConnection) httpurl.openConnection();
        httpUrlConn.setDoInput(true);
        httpUrlConn.setRequestMethod("GET");
        httpUrlConn.connect();

        //获得输入
        InputStream inputStream = httpUrlConn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        //将bufferReader的值给放到buffer里
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        //关闭bufferReader和输入流
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        inputStream = null;
        //断开连接
        httpUrlConn.disconnect();

    } catch(Exception e)

    {
        e.printStackTrace();
    }
    //返回字符串
        return buffer.toString();






    }
}
