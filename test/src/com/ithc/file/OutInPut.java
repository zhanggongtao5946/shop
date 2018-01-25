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
		//Ŀ�ĵ�
		File file = new File("D:/file/OutInPut/qq.exe");
		
		long fileLength = 0;
		if(file.exists()){
			fileLength = file.length();
		}
		
		String src = "http://sw.bos.baidu.com/sw-search-sp/software/43eac3f0c32cb/QQ_9.0.0.22972_setup.exe";
		//����url����
		URL url = new URL(src);
		//����Զ�����Ӷ���
		URLConnection openConnection = url.openConnection();
		//����֧��http������
		if(openConnection instanceof HttpURLConnection){
			HttpURLConnection huc = (HttpURLConnection) openConnection;
			//����������Ϣ
			huc.setRequestProperty("range", "bytes =" + fileLength);
			//��
			InputStream is = huc.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			//д                                                                                 
			FileOutputStream fos = new FileOutputStream(file,true);//��true���Ḳ��
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
