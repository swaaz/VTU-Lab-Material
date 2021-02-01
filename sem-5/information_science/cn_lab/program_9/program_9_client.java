import java.net.*;
import java.io.*;
import java.util.Scanner;

public class try_client {
    public static void main(String args[]) throws Exception {
        String temp;
        Socket s = new Socket("127.0.0.1", 6300);
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name");
        String fname = br.readLine();
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println(fname);
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while ((temp = br1.readLine()) != null) {
            System.out.println(temp);
        }
        s.close();
        sc.close();
    }
}