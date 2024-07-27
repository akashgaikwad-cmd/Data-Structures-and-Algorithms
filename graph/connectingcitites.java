//Connecting cities with minimum cost
import java.util.*;
class connectingcitites{
    static class Edge implements Comparable<Edge>{
        int node,wt;
        public Edge(int node,int wt){
            this.wt=wt;
            this.node=node;
        }
        @Override
        public int compareTo(Edge e2) {
            return this.wt-e2.wt;
        }
    }
    
    public static void connect(int cities[][]){
         PriorityQueue<Edge> q=new PriorityQueue<>();
         boolean visited[]=new boolean[cities.length];
         int finalcost=0;
         q.add(new Edge(0,0));
         while(!q.isEmpty()){
           Edge current=q.remove();
           if(visited[current.node]!=true){
              visited[current.node]=true;
            finalcost+=current.wt;
            for(int i=0;i<cities[current.node].length;i++){
                if(cities[current.node][i]!=0){
                    q.add(new Edge(i,cities[current.node][i]));
                }  
            }
            
    }
}
System.out.println(finalcost);
    }
    
    public static void main(String args[]){
       int cities[][]={{0,1,2,3,4},{1,0,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
       connect(cities);
    }
}