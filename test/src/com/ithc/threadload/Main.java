package com.ithc.threadload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@SuppressWarnings("all")
public class Main {

	public static void main(String[] args) throws Exception {
		down();
	}
	public static void down() throws Exception{
		String src = "http://sw.bos.baidu.com/sw-search-sp/software/43eac3f0c32cb/QQ_9.0.0.22972_setup.exe";
		//����url����
		URL url = new URL(src);
		//����Զ������
		URLConnection connection = url.openConnection();
		// ����Http��ʽ������
		HttpURLConnection huc = (HttpURLConnection) connection;
		long filelength = huc.getContentLengthLong();
		for(int i = 1;i<=DownLoad.N;i++){
			DownLoad load = new DownLoad(src,i,filelength);
			load.start();
			DownLoad.list.add(load);
		}
		//�ϳ�
		Hut hut = new Hut();
		hut.start();
	}
}
