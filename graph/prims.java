//Cycle detection in direct graph
import java.util.*;
class prims{
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
        int v,cost;
        public pair(int v,int cost){
            this.v=v;
            this.cost=cost;
        }
        @Override
        public int compareTo(pair p2){
            return this.cost-p2.cost;
        }
    }
    public static void prims(ArrayList<Edge> graph[]){
        boolean visited[]=new boolean[graph.length];
        PriorityQueue<pair> q=new PriorityQueue<>();
        int finalcost=0;
        q.add(new pair(0,0));
        while(!q.isEmpty()){
          pair curr=q.remove();
          if(visited[curr.v]!=true){
            visited[curr.v]=true;
            finalcost+=curr.cost;
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);
                q.add(new pair(e.dt,e.wt));
            }
          }
        }
        System.out.println("Minimum cost="+finalcost);
        
    }
    
    public static void main(String args[]){
       ArrayList<Edge> graph[]=new ArrayList[7];
       for(int i=0;i<7;i++){
          graph[i]=new ArrayList<>();
       }
       
       graph[0].add(new Edge(10,0,1));
       graph[0].add(new Edge(15,0,2));
       graph[0].add(new Edge(30,0,3));

       graph[1].add(new Edge(10,1,0));
       graph[1].add(new Edge(40,1,3));

       graph[3].add(new Edge(40,3,1));
       graph[3].add(new Edge(50,3,2));
       graph[3].add(new Edge(30,3,0));

       graph[2].add(new Edge(15,2,0));
       graph[2].add(new Edge(50,2,3));
       
       prims(graph);
    }
}