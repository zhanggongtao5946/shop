package com.ithc.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class OutInPut {

	public static void main(String[] args) throws IOException {
		//目的地
		File file = new File("D:/file/OutInPut/qq.exe");
		
		long fileLength = 0;
		if(file.exists()){
			fileLength = file.length();
		}
		
		String src = "http://sw.bos.baidu.com/sw-search-sp/software/43eac3f0c32cb/QQ_9.0.0.22972_setup.exe";
		//创建url对象
		URL url = new URL(src);
		//创建远程连接对象
		URLConnection openConnection = url.openConnection();
		//创建支持http的链接
		if(openConnection instanceof HttpURLConnection){
			HttpURLConnection huc = (HttpURLConnection) openConnection;
			//设置请求消息
			huc.setRequestProperty("range", "bytes =" + fileLength);
			//读
			InputStream is = huc.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			//写                                                                                 
			FileOutputStream fos = new FileOutputStream(file,true);//加true不会覆盖
			byte[] by = new byte[1024];
			int le = -1;
			while((le = bis.read(by)) != -1){
				fos.write(by, 0, le);
			}
			fos.close();
			bis.close();
			
		}
		
		
	}
	
}
