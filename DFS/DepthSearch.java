package DFS;

import java.util.List;

import Graph.Graph;

public class DepthSearch {
    public enum VertexColor {
        WHITE,GREY,BLACK
    };
    public static void Search(Graph g,int pred[],int [] discovered,int [] finished){
        int vertices=g.vertices;
        VertexColor [] color=new VertexColor[vertices];
        for(int i=0;i<vertices;i++){
            pred[i]=-1;
            color[i]=VertexColor.WHITE;
        }
        int time=0;
        for(int i=0;i<vertices;i++){
            if(color[i]==VertexColor.WHITE){
                DepthSearchVisit(g,i,pred, discovered, finished, time, color);
            }
        }

    }
    private static void DepthSearchVisit(Graph g,int u,int pred[],int [] discovered,int [] finished,int time,VertexColor [] color){
        time+=1;
        discovered[u]=time;
        color[u]=VertexColor.GREY;
        List<Integer> AList=g.adjacencyLists[u];
        for(int i=0;i<AList.size();i++){
            int v=AList.get(i);
            if(color[v]==VertexColor.WHITE){
                pred[v]=u;
                DepthSearchVisit(g, v, pred, discovered, finished, time, color);
            }
        }
        color[u]=VertexColor.BLACK;
        time+=1;
        finished[u]=time;
    }
}
