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
		//创建url对象
		URL url = new URL(src);
		//建立远程连接
		URLConnection connection = url.openConnection();
		// 创建Http形式的连接
		HttpURLConnection huc = (HttpURLConnection) connection;
		long filelength = huc.getContentLengthLong();
		for(int i = 1;i<=DownLoad.N;i++){
			DownLoad load = new DownLoad(src,i,filelength);
			load.start();
			DownLoad.list.add(load);
		}
		//合成
		Hut hut = new Hut();
		hut.start();
	}
}
