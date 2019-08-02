import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

class ClientReader extends Thread{
	DataInputStream in;
	InputStream is;
	String msg;
	JTextArea textArea;
	
	ClientReader(Socket socket){
		try {
			is = socket.getInputStream();
			in = new DataInputStream(is);			
			
		}catch(IOException e) {
			e.printStackTrace();
		}		
	}	
	
	public String readMessage() {
		return msg;
	}
	
	public void setMessage() {
		this.msg = null;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void run() {
		try {
			System.out.println("쓰레드시작");
			System.out.println(System.getProperty("file.encoding"));
			byte[] by;

			int count;
			while (in != null) {				
					count = in.available();
					if (count > 0) {
						by = new byte[count];
						for (int i = 0; i < count; i++) {
							by[i] = in.readByte();
						}
						msg = new String(by, "UTF-8");
						textArea.append(msg);
						System.out.println(msg);
					}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}