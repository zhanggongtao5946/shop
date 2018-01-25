package com.ithc.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCut {
	
	public static void main(String[] args) throws IOException {
		File file = new File("D:/file/OutInPut/fg.jpg");
		long fileLength = file.length();
		// ���ÿһ�ݵĴ�С
		int shang = 0;
		int yushu = 0;
		//����
		int n = 3 ;
		if(fileLength % n == 0){
			shang = (int)(fileLength/n);
		}else{
			shang = (int)(fileLength / n);
			yushu = (int)(fileLength % n);
		}
		
		//���������
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		
		//����ָ��
		int seeklen = 0;
		raf.seek(seeklen);
		byte[] by;
		FileOutputStream fos = null;
		File md;
		for(int i = 1;i<=n;i++){
			//����Ŀ�ĵ�
			md = new File(file.getParent()+File.separator+"img_"+i+".temp");
			if(i < n){
				by = new byte[shang];
				raf.read(by);
				fos = new FileOutputStream(md);
				fos.write(by);
				//����ָ���λ��
				seeklen += shang;
				raf.seek(seeklen);
				by = null;
			}else{
				by = new byte[shang + yushu];
				raf.read(by);
				fos = new FileOutputStream(md);
				fos.write(by);
			}
		}
		fos.close();
		
	}
	
}
