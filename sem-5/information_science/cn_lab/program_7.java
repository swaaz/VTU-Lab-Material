import java.util.Scanner;
class CRC{
    public static void main(String args[]){
        int data[]=new int[100];
        int flag=0;
		int div[]=new int[100];
		
        System.out.println("Cyclic Redundancy Check");
        System.out.println("Transmitter Side");
        System.out.println("Enter The Number Of Data Bits");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Enter The Data Bits");
        for(int i=0;i<n;i++){
            data[i]=sc.nextInt();
        }
        System.out.println("Enter The Number of divisor bits");
        int d=sc.nextInt();
        System.out.println("Enter the divisor bits");
        for(int i=0;i<d;i++){
            div[i]=sc.nextInt();
        }
        for(int i=0;i<d-1;i++){
            data[n+i]=0;
        }
        int a=n+d-1;
        System.out.println("Transmitter side data is");
        for(int i=0;i<a;i++){
            System.out.print(data[i]);
            
        }
		System.out.println();
		
        for(int i=0;i<n;i++){
			if (data[i]==1)
			for(int j=i;j<d+i;j++){
				data[j]=data[j]^div[j-i];
            
            
            }
        }
        System.out.println("CRC is");
        for(int i=n;i<a;i++){
            System.out.print(data[i]);
        }
        System.out.println();
        System.out.println("Receiver Side");
        System.out.println("Enter the number of data bits received");
        int n1=sc.nextInt();
        if(n1!=n){
            System.out.print("Data is rejected");	
            sc.close();
            return;
        }
        System.out.println("Enter the data bits received");
        for(int i=0;i<n;i++){
            data[i]=sc.nextInt();
        }
        System.out.println("The data received is");
        for(int i=0;i<a;i++){
            System.out.println(data[i]);
        }
        for(int i=0;i<n;i++){
            if (data[i]==0)
            {
                continue;
            }
            else{
                for(int j=i;j<d+i;j++){
                    data[j]=data[j]^div[j-i];
                }
            }
        }
        System.out.println("The CRC is");
        for(int i=n;i<a;i++){
            System.out.print(data[i]);
        }
        System.out.println();
        for(int i=n;i<a;i++){
            if(data[i]==1){
                flag=1;
                break;
            }
        }
        if(flag==1){
            System.out.println("Resend the data again");
        }
        else{
            System.out.println("Data is accepted");
        }
        sc.close();
    }
}