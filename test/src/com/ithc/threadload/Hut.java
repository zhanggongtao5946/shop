package com.ithc.threadload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Hut extends Thread {
	@Override
	public void run() {
		for (Thread t : DownLoad.list) {
			try {
				t.join();
			} catch (Exception e) {
			}
		}
		// �����Ŀ��·��
		File file = new File("D:/file/OutInPut");
		// �����Ŀ�ĵ�
		File newfile = new File("D:/file/OutInPut", "qq_.exe");
		// ���������
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(newfile, true);
			FileInputStream fis = null;
			for (int i = 1; i <= DownLoad.N; i++) {
				// ��ȡĿ����Ƭ
				File f = new File(file, "qq_" + i + ".temp");
				// ����������
				fis = new FileInputStream(f);
				byte[] by = new byte[2048];
				int len = 0;
				while ((len = fis.read(by)) != -1) {
					fos.write(by, 0, len);
				}
				fis.close();
				f.delete();
			}
			fos.close();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
