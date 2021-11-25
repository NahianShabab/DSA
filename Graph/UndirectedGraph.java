package Graph;

public class UndirectedGraph extends Graph {
    public UndirectedGraph(int v) throws IllegalArgumentException{
        super(v);
    }
    @Override
    public void addEdge(int u,int v){
        if(u >=this.vertices || v>=this.vertices || u<0 || v<0){
            return;
        }
        this.adjacencyLists[u].add( v);
        if(u==v)
            return;
        this.adjacencyLists[v].add(u);
    }
}
