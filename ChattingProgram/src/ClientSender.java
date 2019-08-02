import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.json.simple.JSONObject;

class ClientSender{
	Socket socket;	
	DataOutputStream out;	
	
	ClientSender(Socket socket){				
		try {
			this.socket = socket;
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("outputStream 생성 에러");
			e.printStackTrace();
		}		
	}
	
	public void sendName(String name) {
		String msg = "[ "+ name +" ] 님이 참가하셨습니다.\n";
		sendMessage(name,msg);
	}
	
	@SuppressWarnings("unchecked")
	public void sendMessage(String name, String msg) {
		//HashMap<String, String> json = new HashMap<String, String>();
		JSONObject json = new JSONObject(); 
		json.put("msg",msg);
		json.put("id", name );
		System.out.println(json+"<<");
		if(out!=null) {
			try {
				byte[] j = (json.toString()).getBytes("UTF-8");
				//byte[] b = msg.getBytes("UTF-8");
				out.write(j);			
				out.flush();				
			} catch (IOException ie) {
				System.out.println("write 에러");
				ie.printStackTrace();
			}			
		}		
	}
}