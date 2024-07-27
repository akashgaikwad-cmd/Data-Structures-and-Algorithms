//Cycle detection in direct graph
import java.util.*;
class Allpaths{
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
    
    public static void Allpaths(ArrayList<Edge> graph[],int src,int dest,String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            Allpaths(graph,e.dt,dest,path+src);
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
       int src=5;
       int dest=1;
       String path="";
       Allpaths(graph,src,dest,path);
    }
}