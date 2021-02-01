import java.util.*;
class Bell{
    private int n;
    private int dist[];
    //init the number of nodes and distance matrix which stores the minimum cost from source to that node
    public Bell(int number_of_nodes){
        this.n=number_of_nodes;
        dist=new int[this.n+1];

    }
    //function to perform
    public void BellMan(int x,int adj[][]){
        //init distance matrix value to maximum(999) and distance[source]=0
        for(int i=1;i<=n;i++){
            dist[i]=999;
        }
        dist[1]=0;//this is because distance from 1->1 is 0.

        //loop n-1 times
        for(int i=1;i<n;i++)
            for(int u=1;u<=n;u++)//loop for each node as source
                for(int v=1;v<=n;v++)//loop for each node as destination
                    if(adj[u][v]!=999)//ignore maximum value because that dont have any directed edge from source
                        if(dist[v]>dist[u]+adj[u][v])//if previous cost>new cost 
                            dist[v]=dist[u]+adj[u][v];//then set cost=newcost(or update old cost)

                      

        //to detect -ve cycle if present
        //to check for -ve cycle scince we had reached all the ittiration even though the values of the cost or keep on changing hence our graph has -ve cycle
        for(int u=1;u<=n;u++)
            for(int v=1;v<=n;v++)
                if(adj[u][v]!=999)
                    if(dist[v]>dist[u]+adj[u][v])
                        System.out.println("Graph has -ve edge cycles:");       

        //printing cost the x->all nodes
        for(int i=1;i<=n;i++)
        System.out.println("Cost from "+x+" to "+i+" is:"+dist[i]);
        
        
    }

    public static void main(String args[]){
        int n=0;
        int u,v;
        Scanner in=new Scanner(System.in);


        //Read how many nodes?
        System.out.println("Enter Number of nodes:");
        n=in.nextInt();
        int[][] adj=new int[n+1][n+1];

        //Enter cost Matrix
        System.out.println("Enter the adjecency matrix:");
        for(u=1;u<=n;u++){
            for(v=1;v<=n;v++){
                adj[u][v]=in.nextInt();
            }
        }
        //Initalize cost matrix set adj[u][v]=0 if u==v 
        //Initalize cost matrix set adj[u][v]=999 if adj[u][v]==0 
        for(u=1;u<=n;u++){
            for(v=1;v<=n;v++){
                if(u==v){
                    adj[u][v]=0;
                    continue;
                }
                if(adj[u][v]==0){
                    adj[u][v]=999;
                }
            }
        }
        // for(u=1;u<=n;u++){
        //     for(v=1;v<=n;v++){
        //         System.out.print(adj[u][v]);
        //     }
        //     System.out.println();
        // }
        //Enter souce vertex
        System.out.println("Enter the Source vertex:");
        int x=in.nextInt();
        Bell b=new Bell(n);
        b.BellMan(x,adj);



    }
}