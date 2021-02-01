import java.net.*;
import java.io.*;
public class Client {    
    public static void main(String args[])throws Exception    {        
        Socket s=new Socket("127.0.0.1",6300);        
        BufferedReader fbuf=new BufferedReader(new InputStreamReader(System.in));        
        String fname=fbuf.readLine();
        PrintWriter pr=new PrintWriter(s.getOutputStream(),true);        
        pr.println(fname);        
        BufferedReader Conbuf=new BufferedReader(new InputStreamReader(s.getInputStream()));        
        String Temp;        
        while((Temp=Conbuf.readLine())!=null){            
            System.out.println(Temp);        
        }        
        Conbuf.close();        
        pr.close();        
        fbuf.close();        
        s.close();    
    }
}