//Cycle detection in direct graph
import java.util.*;
class Di{
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
    static class pair implements Comparable<pair>{
        int node,path;
        public pair(int node,int path){
            this.node=node;
            this.path=path;
        }
        @Override
        public int compareTo(pair p2){
            return this.path-p2.path;
        }
    }
    public static void dj(ArrayList<Edge> graph[],int src){
     boolean visited[]=new boolean[graph.length];
     int dist[]=new int[graph.length];
     for(int i=0;i<dist.length;i++){
        if(src!=i){
            dist[i]=Integer.MAX_VALUE;
        }
     }
     PriorityQueue<pair> q=new PriorityQueue<>();
     q.add(new pair(0,0));
     while(!q.isEmpty()){
        pair curr=q.remove();
        if(visited[curr.node]!=true){
            visited[curr.node]=true;
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                int u=e.sr;
                int v=e.dt;
                int w=e.wt;
                if((dist[u]+w)<dist[v]){
                    dist[v]=dist[u]+w;
                    q.add(new pair(e.dt,dist[v]));
                }
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
       dj(graph,src);
    }
}