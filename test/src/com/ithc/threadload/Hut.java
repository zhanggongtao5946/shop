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
		// 重组的目标路径
		File file = new File("D:/file/OutInPut");
		// 重组的目的地
		File newfile = new File("D:/file/OutInPut", "qq_.exe");
		// 创建输出流
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(newfile, true);
			FileInputStream fis = null;
			for (int i = 1; i <= DownLoad.N; i++) {
				// 获取目标碎片
				File f = new File(file, "qq_" + i + ".temp");
				// 创建输入流
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
