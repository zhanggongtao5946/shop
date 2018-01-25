package com.ithc.threadload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class DownLoad extends Thread {
	
	static List<Thread> list = new ArrayList<Thread>();
	// 路径
	String src;
	//开始位置
	long start;
	// 结束位置
	long end;
	//当次的碎片
	int i;
	//碎片的个数
	static final int N = 5;
	public DownLoad(String src,int i,long filelength){
		this.src = src;
		this.i= i;
		// 505   5
		// shang = 100 5-1 = 4 * 100(shang)
		int shang = (int) (filelength / N);
		//第一次
		if(i == 1){
			start = 0;
			end = shang;
		//最后一次
		}else if(N == i){
			// +1 解决重复字段
			start = (i-1)*shang + 1;
			end = filelength;
		//其余的次数
		}else{
			start = (i-1)*shang + 1;
			end = i*shang;
		}
	}
	
	@Override
	public void run() {
		try {
			URL url = new URL(src);
			URLConnection connection = url.openConnection();
			HttpURLConnection huc = (HttpURLConnection) connection;
			//根据不同的位置去请求服务器资源
			huc.setRequestProperty("Range", "bytes="+start+"-"+end);
			// 文件写入的目的地
			File file = new File("D:/file/OutInPut","qq_"+i+".temp");
			//创建输出流
			FileOutputStream fos = new FileOutputStream(file);
			//创建输入流
			InputStream is = huc.getInputStream();
			byte[] by = new byte[2048];
			int len = 0;
			while((len = is.read(by)) != -1){
				fos.write(by, 0, len);
			}
			is.close();
			fos.close();
		} catch (Exception e) {
		}
	}

}
