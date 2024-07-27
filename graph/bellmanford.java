//Cycle detection in direct graph
import java.util.*;
class bellmanford{
    static class Edge{
        int wt;
        int sr;
        int dt;
        Edge(int w,int s,int d){
            this.wt=w;
            this.sr=s;
            this.dt=d;
        }
    }
    public static void bellman(ArrayList<Edge> graph[],int src){
        int dist[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<graph.length-1;i++){
            for(int j=0;j<graph[i].size();i++){
                Edge e=graph[i].get(j);
                if(dist[e.sr]!=Integer.MAX_VALUE && dist[e.sr]+e.wt<dist[e.dt]){
                    dist[e.dt]=dist[e.sr]+e.wt;
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            System.out.println(dist[i]+" ");
        }
    }
    
    
    public static void main(String args[]){
       ArrayList<Edge> graph[]=new ArrayList[7];
       for(int i=0;i<7;i++){
          graph[i]=new ArrayList<>();
       }
       
       graph[0].add(new Edge(1,0,3));
       graph[2].add(new Edge(1,2,3));
       graph[3].add(new Edge(1,3,1));
       graph[4].add(new Edge(1,4,0));
       graph[4].add(new Edge(1,4,1));
       graph[5].add(new Edge(1,5,0));
       graph[5].add(new Edge(1,5,2));
       int src=0;
       bellman(graph,src);
    }
}