package Graph;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph {
    public List<Integer> [] adjacencyLists=null;
    public int vertices;
    
    public Graph(int v) throws IllegalArgumentException{
        if(v<=0)
            throw new IllegalArgumentException("vertex number cannot be less than 1");
        this.vertices=v;
        adjacencyLists=new List[vertices];
        for(int i=0;i<vertices;i++)
            adjacencyLists[i]=new ArrayList<Integer>();
    }

    public abstract void addEdge(int u,int v);

    public void printGraph(){
        for(int i=0;i<vertices;i++){
            System.out.print(i+": ");
            int l=adjacencyLists[i].size();
            for(int j=0;j<l;j++){
                System.out.print(adjacencyLists[i].get(j)+", ");
            }
            System.out.println();
        }
    }

}
