import java.util.*;
class DFS{
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
    public static void dfs(ArrayList<Edge> graph[],boolean visited[],int current){
       System.out.print(current+" ");
       for(int i=0;i<graph[current].size();i++){
         Edge e=graph[current].get(i);
         if(visited[e.dt]!=true){
            visited[e.dt]=true;
            dfs(graph,visited,e.dt);
         }
       }
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

       boolean visited[]=new boolean[7];
       visited[0]=true;
       
       dfs(graph,visited,0);
    }
}