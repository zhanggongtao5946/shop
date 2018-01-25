package com.ithc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class FileHut {
	
	public static void main(String[] args) throws Exception {
		hut();
	}
	
	public static void hut() throws Exception {
		//重组文件的路径
		File file = new File("D:/file/OutInPut/hut.jpg");
		// 如何获取所有的碎片
		//1.获取目录
		String parentName = file.getParent();
		File parent = new File(parentName);
		File[] files = parent.listFiles();
		//创建随机流
		RandomAccessFile arf = new RandomAccessFile(file,"rw");
		//设置指针的位置
		int seeklen = 0;
		arf.seek(seeklen);
		FileInputStream fis = null;
		for(int i = 0;i<files.length;i++){
			//筛选碎片
			File f = files[i];
			String filename = f.getName();
			if(filename.endsWith(".temp")){
				fis = new FileInputStream(f);
				byte[] by = new byte[(int) f.length()];
				// 读
				fis.read(by);
				//写
				arf.write(by);
				//设置指针
				seeklen += f.length();
				arf.seek(seeklen);
			}
		}
		arf.close();
		fis.close();
	}
}
