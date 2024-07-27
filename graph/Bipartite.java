//Cycle detection in undirect graph
import java.util.*;
class Bipartite{
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
    public static boolean bipartite(ArrayList<Edge> graph[]){
       int col[]=new int[graph.length];
       for(int i=0;i<col.length;i++){
        col[i]=-1;
       }
       Queue<Integer> q=new LinkedList<>();
       q.add(0);
       col[0]=0;
       while(!q.isEmpty()){
           Integer Current=q.remove();
           for(int i=0;i<graph[Current].size();i++){
              Edge e=graph[Current].get(i);
              if(col[e.dt]==-1){
                col[e.dt]=(col[Current]==0)?1:0;
              }else if(col[e.dt]==col[Current]){
                return false;
              }
           }
       }
       return true;
    }
    
    public static void main(String args[]){
       ArrayList<Edge> graph[]=new ArrayList[7];
       for(int i=0;i<7;i++){
          graph[i]=new ArrayList<>();
       }
       graph[0].add(new Edge(1,0,1));
       graph[0].add(new Edge(1,0,2));

       graph[1].add(new Edge(1,1,0));
       graph[1].add(new Edge(1,1,3));

       graph[2].add(new Edge(1,2,0));
       graph[2].add(new Edge(1,2,4));

       graph[3].add(new Edge(1,3,1));
       graph[3].add(new Edge(1,3,4));
       graph[3].add(new Edge(1,3,5));
       
 
       graph[4].add(new Edge(1,4,2));
       graph[4].add(new Edge(1,4,5));

       graph[5].add(new Edge(1,5,3));
       graph[5].add(new Edge(1,5,4));
       graph[5].add(new Edge(1,5,6));

       graph[6].add(new Edge(1,6,5));
       
       System.out.println(bipartite(graph));
    }
}