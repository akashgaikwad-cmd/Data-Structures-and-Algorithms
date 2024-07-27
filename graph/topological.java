//Cycle detection in direct graph
import java.util.*;
class topological{
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
    public static void toposort(ArrayList<Edge> graph[]){
        Stack<Integer> s=new Stack<>();
        boolean visited[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]==false){
                toposortutil(graph,s,visited,i);
            }
        }
        while(!s.isEmpty()){
          System.out.println(s.pop()+"");
        }
    }
    public static void toposortutil(ArrayList<Edge> graph[],Stack<Integer> s,boolean visited[],int current){
        visited[current]=true;
        for(int i=0;i<graph[current].size();i++){
            Edge e=graph[current].get(i);
            if(!visited[e.dt]){
                toposortutil(graph,s,visited,e.dt);
            }
        }
        s.push(current);
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