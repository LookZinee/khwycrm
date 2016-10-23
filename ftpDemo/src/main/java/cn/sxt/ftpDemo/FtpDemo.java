package cn.sxt.ftpDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FtpDemo {
	public static void main(String[] args) throws IOException {
		FTPClient ftp = new FTPClient();
		InputStream local =null;
		try {
			//建立连接
			ftp.connect("192.168.88.10", 21);
			//指定用户名和密码
			ftp.login("ftpuser", "4385242");
			
			
			File file = new File("D:\\abc.jpg");
			local = new FileInputStream(file);
			
			String path = "/home/ftpuser/www";
			boolean flag = ftp.changeWorkingDirectory(path);
			if( !flag){
				ftp.makeDirectory(path);
				ftp.changeWorkingDirectory(path);
			}
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.storeFile(file.getName(), local);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				local.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ftp.logout();
			ftp.disconnect();
		}
	}
}
