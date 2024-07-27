//Cycle detection in direct graph
import java.util.*;
class cycle_directed{
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
    
   public static boolean iscycle(ArrayList<Edge> graph[]){
    boolean visited[]=new boolean[graph.length];
    boolean stack[]=new boolean[graph.length];
    for(int i=0;i<graph.length;i++){
        if(!visited[i]){
            if(isscycleutil(graph,visited,stack,i)){
                return true;
            }
        }
    }
    return false;
   }
    public static boolean isscycleutil(ArrayList<Edge> graph[],boolean visited[],boolean stack[],int current){
        visited[current]=true;
        stack[current]=true;
        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(stack[e.dt]==true){
                return true;
            }else if(!visited[e.dt] && isscycleutil(graph,visited,stack,e.dt)){
                return true;
            }
        }
        stack[current]=false;
        return false;
    }
    
    public static void main(String args[]){
       ArrayList<Edge> graph[]=new ArrayList[7];
       for(int i=0;i<7;i++){
          graph[i]=new ArrayList<>();
       }
       
       graph[0].add(new Edge(1,0,2));

       graph[1].add(new Edge(1,1,0));
       

       graph[2].add(new Edge(1,2,3));
       

       graph[3].add(new Edge(1,3,0));
       
       System.out.println(iscycle(graph));
    }
}