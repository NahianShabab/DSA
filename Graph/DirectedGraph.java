package Graph;

public class DirectedGraph extends Graph{
    public DirectedGraph(int v) throws IllegalArgumentException{
        super(v);
    }
    @Override
    public void addEdge(int u,int v){
        if(u >=this.vertices || v>=this.vertices || u<0 || v<0){
            return;
        }
        this.adjacencyLists[u].add(v);
    }
}