package org.example.sec02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class CopyTask implements Runnable {

	String sourceFile;
	String destFile;

	public CopyTask(String sourceFile, String destFile) {
		this.sourceFile = sourceFile;
		this.destFile = destFile;
	}

	public void run() {
		try {
			IOUtils.copyFile(sourceFile, destFile);
			System.out.println("Copied from - " + sourceFile + " to " + destFile);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
}

public class IOUtils {
	
	public static void copy(InputStream src, OutputStream dest) throws IOException {
		int value;
		while ((value = src.read()) != -1) {
			dest.write(value);
		}
	}
	
	public static void copyFile(String srcFile, String destFile) throws IOException {
		FileInputStream fin = new FileInputStream(srcFile);
		FileOutputStream fout = new FileOutputStream(destFile);
		
		IOUtils.copy(fin, fout);
		
		fin.close();
		fout.close();
	}
}