import java.io.*;
import java.util.*;
class rsa{
    static int mult(int x,int y,int z){  //to calculate cipher text
        int k=1;
        for(int i=0;i<y;i++)
        k=((k*x)%z);
        return (int)k;
    }
    public static void main(String args[]) throws Exception{
        int pt[]=new int[30];
        int ct[]=new int[30];
        int d=0;
        System.out.println("Enter P and Q values");  //p*q>127
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int n=p*q;
        int z=(p-1)*(q-1);
        System.out.println("Enter the e value");
        int e=sc.nextInt();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Text Mesaage");
        String msg=br.readLine();
        char msg1[]=msg.toCharArray();
        for(int i=0;i<msg1.length;i++){
            pt[i]=msg1[i];                    //converting to ascii
        }
        for(d=1;d<z;++d){
            if(((e*d)%z)==1){                    //to find d value
                break;
            }
        }
        System.out.println("p="+p+" q="+q+" n="+n+" e="+e+" z="+z+" d="+d);
        for(int i=0;i<msg1.length;i++){
            ct[i]=mult(pt[i],e,n);            //finding cipher text using public key(e)
        }
        System.out.println("Cipher text is");
        for(int i=0;i<msg1.length;i++){
            System.out.print(ct[i]+" ");        
        }
        System.out.println("\nPlain Text");
        for(int i=0;i<msg1.length;i++){
            pt[i]=mult(ct[i],d,n);
            msg1[i]=(char)pt[i];              //finding plain text using private key(d)
        }
        for(int i=0;i<msg1.length;i++)
        System.out.print(msg1[i]);
        sc.close();
    }
    
}