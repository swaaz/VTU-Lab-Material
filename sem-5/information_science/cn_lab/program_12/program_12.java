import java.util.Scanner;
public class leaky {
    public static void main(String args[]){
        int inp[]=new int[30];
        int count=0;
        int drop=0;
        int mini,i;
        System.out.println("Enter Size Of the bucket");
        Scanner sc=new Scanner(System.in);
        int cap=sc.nextInt();
        System.out.println("Enter the output rate");
        int out=sc.nextInt();
        System.out.println("Enter the number of packets");
        int n=sc.nextInt();
        System.out.println("Enter size of the packets");
        for(i=0;i<n;i++)
            inp[i]=sc.nextInt();
        System.out.println("Second\tPacket Received\tPacket Sent\tPacket Left\tDrop");
        for(i=0;i<n;i++){
            count+=inp[i];
            if(count>cap){
                drop=count-cap;
                count=cap;
            }
            if(count>out){
                mini=out;
                count-=out;
            }
            else{
                mini=count;
                count=0;
            }
            System.out.println(i+1+"\t"+inp[i]+"\t\t"+mini+"\t\t"+count+"\t\t"+drop);
            drop =0;
        }
        for(;count!=0;i++){                    //if data is remaining in bucket after input becomes null
            if(count>cap){
                drop=count-cap;
                count=cap;
            }
            if(count>out){
                mini=out;
                count-=out;
            }
            else{
                mini=count;
                count=0;
            }
            System.out.println(i+1+"\t"+inp[i]+"\t\t"+mini+"\t\t"+count+"\t\t"+drop);
            drop = 0;
        }
        sc.close();
    }
}



