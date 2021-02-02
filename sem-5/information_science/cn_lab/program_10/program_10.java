import java.io.*;
import java.net.*;
class Dataudp{    
    public static int serverport=1632;
    public static int clientport=1633;    
    public static byte[] buffer=new byte[100];    
    public static DatagramSocket ds;    

    public static void Theserver()throws Exception{        
        int pos=0;        
        while(true){            
            int c=System.in.read();            
            switch(c){                
                case -1:System.out.println("Server Quits");                
                        return;                
                case '\r':break;                
                case '\n':ds.send(new DatagramPacket(buffer,pos,InetAddress.getLocalHost(),clientport));                
                            pos=0;                
                            break;                
                default:buffer[pos++]=(byte)c;            
            }        
        }    
    }    

    public static void Theclient()throws Exception{        
        while(true){            
            DatagramPacket p=new DatagramPacket(buffer, buffer.length);            
            ds.receive(p);            
            System.out.println(new String(p.getData(),0,p.getLength()));        
        }    
    }
    
    public static void main(String args[])throws Exception{    
        if(args.length==1){        
            ds=new DatagramSocket(serverport);        
            Theserver();    
        }    
        else{        
            ds=new DatagramSocket(clientport);        
            Theclient();    
        }
    }
}