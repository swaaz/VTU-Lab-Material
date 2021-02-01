import java.net.*;
import java.io.*;
public class Server {    
    public static void main(String args[])throws Exception    {        
        ServerSocket ss=new ServerSocket(4000);        
        System.out.println("Lisining to the network........");        
        Socket s=ss.accept();        
        System.out.println("Connection Sucessfull and ready for chatting");        
        BufferedReader fbuf=new BufferedReader(new InputStreamReader(s.getInputStream()));        
        String fname=fbuf.readLine();        
        System.out.println(fname);        
        BufferedReader contentbuf=new BufferedReader(new FileReader(fname));        
        PrintWriter pr=new PrintWriter(s.getOutputStream(),true);        
        String Temp;        
        while((Temp=contentbuf.readLine())!=null){            
            pr.println(Temp);        
        }        
        pr.flush();        
        contentbuf.close();        
        fbuf.close();        
        s.close();        
        ss.close();    
    }
}