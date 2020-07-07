import java.net.*;
import java.util.Scanner;
import java.io.*;

public class server {
		public static void main(String[] args) throws IOException {

		int number, temp;

		ServerSocket ss = new ServerSocket(4999);
		Socket s = ss.accept();
		Scanner sc = new Scanner(s.getInputStream());
		number = sc.nextInt();

		temp = number*2;

		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(temp);

		}
}