package tcp_sock;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Tcp_server {
	public static void main(String[] args)
	{
	try {
		ServerSocket server = new ServerSocket(10001);
		System.out.println("Wating Connect ...");
		
		Socket sock = server.accept();
		InetAddress inetaddr = sock.getInetAddress();
		System.out.println(inetaddr.getHostAddress()+"에서 접속하였습니다.");
		OutputStream ops = sock.getOutputStream();
		InputStream ips = sock.getInputStream();
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(ops));
		BufferedReader br = new BufferedReader(new InputStreamReader(ips));
		
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println("클라이언트로부터 전송받은 문자열 : "+line);
			pw.println(line);
			pw.flush();
		}
		 
		pw.close();
		br.close();
		sock.close();
		
		
	}catch(Exception e) {
		System.out.println(e);
	}
	}
}


