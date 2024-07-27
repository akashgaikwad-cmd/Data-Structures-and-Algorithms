//Cycle detection in direct graph
import java.util.*;
class cheapest_path{
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
    static class Info{
        int n,cost,stops;
        public Info(int n,int cost,int stops){
            this.n=n;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public static void creategraph(ArrayList<Edge> graph[],int flights[][]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            Edge e=new Edge(flights[i][2],flights[i][0],flights[i][1]);
            graph[flights[i][0]].add(e);
        }
    }
   public static int cheapestpath(int n, int flights[][], int src, int dest, int k) {
    ArrayList<Edge> graph[] = new ArrayList[n];
    creategraph(graph, flights);
    int dist[] = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    Queue<Info> q = new LinkedList<>();
    q.add(new Info(src, 0, 0));
    while (!q.isEmpty()) {
        Info curr = q.remove();
        if (curr.stops > k) {
            break;
        }
        for (int i = 0; i < graph[curr.n].size(); i++) {
            Edge e = graph[curr.n].get(i);
            if ((curr.cost + e.wt) < dist[e.dt]) {
                dist[e.dt] = curr.cost + e.wt;
                q.add(new Info(e.dt, dist[e.dt], curr.stops + 1));
            }
        }
    }
    return (dist[dest] == Integer.MAX_VALUE) ? -1 : dist[dest];
}

    
    
    
    public static void main(String args[]){
       int n=4;
       int flights[][]={{0,1,100},{1,2,100},{1,3,600},{2,1,100},{2,3,200}};
       System.out.println(cheapestpath(n,flights,0,3,1));
    }
}