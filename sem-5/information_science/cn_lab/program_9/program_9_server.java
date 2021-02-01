
import java.net.*;
import java.io.*;

public class try_server {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(6300);
        String temp;
        System.out.println("Listening to the network");
        Socket s = ss.accept();
        System.out.println("Connected");
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String fname = br.readLine();
        BufferedReader br1 = new BufferedReader(new FileReader(fname));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        while ((temp = br1.readLine()) != null) {
            pw.println(temp);
        }
        br.close();
        br1.close();
        s.close();
        ss.close();

    }
}
