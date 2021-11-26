
import BFS.BreadthFirstSearch;
import BFS.BreadthFirstSearch.VertexColor;
import DFS.DepthSearch;
import Graph.DirectedGraph;
import Graph.Graph;
import Graph.UndirectedGraph;

public class Main{
    public static void main(String[] args) {
        DirectedGraph g=new DirectedGraph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(0, 3);        
        g.addEdge(4, 3);        
        int [] dist=new int[g.vertices];
        VertexColor [] color=new VertexColor[g.vertices];
        int [] pred=new int [g.vertices];
        DepthSearch.Search(g, pred, new int[g.vertices], new int [g.vertices]);
        // for(int i=0;i<g.vertices;i++)
        //     System.out.println("distance of "+i+" :"+dist[i]);
    }
    public static void printBFSTree(int [] pred ){
        for(int i=0;i<pred.length;i++){
            System.out.println("node : "+i+" parent: "+pred[i]);
        }
    }
    public static void printBFSPath(int [] pred,int s,int v){
        if(v==s){
            System.out.println(v+" ");
            return;
        }
        if(pred[v]==-1){
            System.out.println("no path exists");
            return;
        }
        else{
            printBFSPath(pred, s, pred[v]);
            System.out.println(v+" ");
        }
    }
}