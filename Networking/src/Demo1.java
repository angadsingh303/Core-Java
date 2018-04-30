import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress inet = InetAddress.getLocalHost();
		String add=inet.getHostAddress();
		System.out.println(add);
		System.out.println(inet.getHostName()+" "+inet.getHostAddress());
		
		
	/*	System.out.println("Enter the Host Name");
		String hostName = new Scanner(System.in).next();
		InetAddress address[]= InetAddress.getAllByName(hostName);
		for(InetAddress add : address){
			System.out.println(add.getHostAddress());
		}*/
		
		
		URL url = new URL("http://www.cricbuzz.com");
		URLConnection con = url.openConnection();
		con.connect();
		InputStream is = con.getInputStream();
		int read = is.read();
		StringBuffer sb = new StringBuffer();
		while(read!=-1){
			sb.append((char)read);
			read = is.read();
		}
		is.close();
		String s = sb.toString();
		
		s=sb.substring(sb.indexOf("England need"), sb.indexOf("England need")+21);
		System.out.println(s);
		
	}

}
