import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
		public static void main(String[] args) throws IOException {
	
			int number, temp;

			Socket s = new Socket("localhost", 4999);
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(s.getInputStream());
			System.out.println("Geben sie eine Nummer ein, die Verdoppelt werden soll: ");
			System.out.println();
			number = sc.nextInt();
	
			PrintStream p = new PrintStream(s.getOutputStream());
			p.println(number);
			temp = sc1.nextInt();
			System.out.println(temp);
		}
}