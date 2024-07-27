//Cycle detection in direct graph
import java.util.*;
class topological_bfs{
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
    public static void calculateindegree(ArrayList<Edge> graph[],int indegree[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                indegree[e.dt]++;
            }
        }
    }
        
    public static void toposort(ArrayList<Edge> graph[]){
       int indegree[]=new int[graph.length];
       calculateindegree(graph,indegree);
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0){
            q.add(i);
        }
       }
       while(!q.isEmpty()){
         Integer current=q.remove();
         System.out.println(current);
         for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            indegree[e.dt]--;
            if(indegree[e.dt]==0){
                q.add(e.dt);
            }
         }
       }
    }
   
    
    public static void main(String args[]){
       ArrayList<Edge> graph[]=new ArrayList[3];
       for(int i=0;i<3;i++){
          graph[i]=new ArrayList<>();
       }
       
       graph[0].add(new Edge(1,0,1));
       graph[0].add(new Edge(1,0,2));
       graph[1].add(new Edge(1,1,2));
       /*-----0--------
            /   \
       ----1----->2-----*/
       
       toposort(graph);
    }
}