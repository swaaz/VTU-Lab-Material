import java.util.Scanner;
public class bell {
    public static void main(String args[]){

        System.out.println("Enter the number of nodes");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int adj[][]=new int[n+1][n+1];

        System.out.println("Enter the adjacency matrix");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                adj[i][j]=sc.nextInt();
            
        
        for(int i=1;i<=n;i++)
            for(int j =1; j<=n; j++)
                if (i==j)   
                    adj[i][j] = 0;
                else 
                    if(adj[i][j]==0)
                        adj[i][j] = 999;

        int dist[]=new int[n+1];
        System.out.println("Enter the source node");
        int s=sc.nextInt();

        for(int i=1;i<=n;i++)
            dist[i]=999;
        
        dist[s]=0;
        for(int i=1;i<=n;i++)
            for(int u=1;u<=n;u++)
                for(int v=1;v<=n;v++)
                    if(adj[u][v]!= 999)
                        if(dist[v] > dist[u]+adj[u][v])
                            dist[v] = dist[u]+adj[u][v];

        for(int u=1;u<=n;u++)
            for(int v=1;v<=n;v++)
                if(adj[u][v]!= 999)
                    if(dist[v] > dist[u]+adj[u][v])
                        System.out.println("Negative edge detected");

        for(int i=1;i<=n;i++)
            System.out.println("cost from "+s+" to "+i+" is "+dist[i]);
        
    }
}

