package DailyAdviceServer;
import java.io.*;
import java.net.*;

public class DailyAdviceServer {
	String[] adviceList = {"Take smaller bits", "Go for the tight jeans. No they do NOT make you look fat.",
			"One word: inappropiate", "Just for today, be honest. Tell your boss what ypu *really* think"};
	
	public void go() {
		try {
			
			ServerSocket serverSock = new ServerSocket(4242);
			
			// 伺服器進入無群迴圈等待服務用戶端的要求
			while(true) {
				// accept() 會停下來等待要求到達之後才會繼續
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
	
	public static void main(String[] arg) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
}
