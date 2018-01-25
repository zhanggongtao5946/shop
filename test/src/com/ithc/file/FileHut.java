package com.ithc.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;

public class FileHut {
	
	public static void main(String[] args) throws Exception {
		hut();
	}
	
	public static void hut() throws Exception {
		//�����ļ���·��
		File file = new File("D:/file/OutInPut/hut.jpg");
		// ��λ�ȡ���е���Ƭ
		//1.��ȡĿ¼
		String parentName = file.getParent();
		File parent = new File(parentName);
		File[] files = parent.listFiles();
		//���������
		RandomAccessFile arf = new RandomAccessFile(file,"rw");
		//����ָ���λ��
		int seeklen = 0;
		arf.seek(seeklen);
		FileInputStream fis = null;
		for(int i = 0;i<files.length;i++){
			//ɸѡ��Ƭ
			File f = files[i];
			String filename = f.getName();
			if(filename.endsWith(".temp")){
				fis = new FileInputStream(f);
				byte[] by = new byte[(int) f.length()];
				// ��
				fis.read(by);
				//д
				arf.write(by);
				//����ָ��
				seeklen += f.length();
				arf.seek(seeklen);
			}
		}
		arf.close();
		fis.close();
	}
}
