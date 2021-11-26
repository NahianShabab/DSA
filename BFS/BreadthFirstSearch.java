package BFS;

import java.util.LinkedList;
import java.util.List;

import Graph.Graph;

public class BreadthFirstSearch {
    public enum VertexColor{
         WHITE,BLACK,GREY
    };

    public static void search(Graph g,int s,int [] pred, VertexColor [] color,int dist[]){
        int vertices=g.vertices;
        for(int i=0;i<vertices;i++){
            pred[i]=-1;
            color[i]=VertexColor.WHITE;
            dist[i]=-1;
        }
        LinkedList<Integer> queue=new LinkedList<Integer>();
        color[s]=VertexColor.GREY;
        dist[s]=0;
        queue.addLast(s);
        while(!queue.isEmpty()){
            int u=queue.removeFirst();
            List<Integer> AList=g.adjacencyLists[u];
            for(int i=0;i<AList.size();i++){
                if(color[AList.get(i)]==VertexColor.WHITE){
                    color[AList.get(i)]=VertexColor.GREY;
                    pred[AList.get(i)]=u;
                    dist[AList.get(i)]=dist[u]+1;
                    queue.addLast(AList.get(i));
                }
            }
            color[u]=VertexColor.BLACK;
        }
    }

}
