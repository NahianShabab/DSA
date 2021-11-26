
import BFS.BreadthFirstSearch;
import BFS.BreadthFirstSearch.VertexColor;
import Graph.Graph;
import Graph.UndirectedGraph;

public class Main{
    public static void main(String[] args) {
        UndirectedGraph g=new UndirectedGraph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        int [] dist=new int[g.vertices];
        VertexColor [] color=new VertexColor[g.vertices];
        int [] pred=new int [g.vertices];
        int source=3;
        BreadthFirstSearch.Search(g, source, pred, color, dist);

        for(int i=0;i<g.vertices;i++)
            System.out.println(dist[i]);
    }
}