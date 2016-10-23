package cn.sxt.ftpDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.UUID;

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
			String basePath = "/";
			String path = "/home/ftpuser/www/2016/10/23";
			for (String string : path.split("/")) {
				basePath = basePath +string +"/";
				boolean flag = ftp.changeWorkingDirectory(basePath);
				if( !flag){
					ftp.makeDirectory(basePath);
					ftp.changeWorkingDirectory(basePath);
				}
			}
			
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			
			String newFileName = getNewFileName(file.getName());
			ftp.storeFile(newFileName, local);
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

	private static String getNewFileName(String name) {
		String uuid = UUID.randomUUID().toString();
		String houzhui = name.substring(name.indexOf("."));
		return uuid+houzhui;
	}
}
