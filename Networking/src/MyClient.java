import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		String ipAddress ="192.168.0.13";
		final int PORTNO=9999;
		Socket socket = new Socket(ipAddress,PORTNO);
		InputStream in = socket.getInputStream();
		int singleByte = in.read();
		while(singleByte!=-1){
			System.out.print((char)singleByte);
			singleByte=in.read();
		}
		in.close();
		socket.close();
		//System.out.println("Enter the message to be sent to Server");
		//String message = new Scanner(System.in).nextLine();
		

	}

}
