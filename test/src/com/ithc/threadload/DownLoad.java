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
	// ·��
	String src;
	//��ʼλ��
	long start;
	// ����λ��
	long end;
	//���ε���Ƭ
	int i;
	//��Ƭ�ĸ���
	static final int N = 5;
	public DownLoad(String src,int i,long filelength){
		this.src = src;
		this.i= i;
		// 505   5
		// shang = 100 5-1 = 4 * 100(shang)
		int shang = (int) (filelength / N);
		//��һ��
		if(i == 1){
			start = 0;
			end = shang;
		//���һ��
		}else if(N == i){
			// +1 ����ظ��ֶ�
			start = (i-1)*shang + 1;
			end = filelength;
		//����Ĵ���
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
			//���ݲ�ͬ��λ��ȥ�����������Դ
			huc.setRequestProperty("Range", "bytes="+start+"-"+end);
			// �ļ�д���Ŀ�ĵ�
			File file = new File("D:/file/OutInPut","qq_"+i+".temp");
			//���������
			FileOutputStream fos = new FileOutputStream(file);
			//����������
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
