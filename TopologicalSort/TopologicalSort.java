package TopologicalSort;

import java.util.LinkedList;
import java.util.List;

import Graph.DirectedGraph;

public class TopologicalSort {
    public static LinkedList<Integer> sort(DirectedGraph g){
        int [] pred=new int[g.vertices];
        int [] discovered=new int[g.vertices];
        int [] finished=new int[g.vertices];
        LinkedList<Integer> list=search(g, pred, discovered, finished);
        return list;
    }
    private enum VertexColor {
        WHITE,GREY,BLACK
    };
    private static int time=0;
    private static boolean hasCycle=false;
    private static LinkedList<Integer> search(DirectedGraph g,int pred[],int [] discovered,int [] finished){
        int vertices=g.vertices;
        VertexColor [] color=new VertexColor[vertices];
        for(int i=0;i<vertices;i++){
            pred[i]=-1;
            color[i]=VertexColor.WHITE;
        }
        time=0;
        hasCycle=false;
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<vertices;i++){
            if(color[i]==VertexColor.WHITE){
                depthSearchVisit(g,i,pred, discovered, finished, color,list);
            }
        }
        if(hasCycle)
            return null;
        return list;
    }
    private static void depthSearchVisit(DirectedGraph g,int u,int pred[],int [] discovered,
        int [] finished,VertexColor [] color,LinkedList<Integer> list){
        time+=1;
        discovered[u]=time;
        color[u]=VertexColor.GREY;
        List<Integer> AList=g.adjacencyLists[u];
        for(int i=0;i<AList.size();i++){
            int v=AList.get(i);
            if(color[v]==VertexColor.WHITE){
                pred[v]=u;
                //System.out.println("Tree: ("+u+","+v+")");
                depthSearchVisit(g, v, pred, discovered, finished, color,list);
            }
            else if(color[v]==VertexColor.GREY){
                //System.out.println("Back: ("+u+","+v+")");
                hasCycle=true;
            }
            else if(color[v]==VertexColor.BLACK){
                if(discovered[u]<discovered[v]){
                    //System.out.println("Forward: ("+u+","+v+")");
                }
                else{
                    //System.out.println("Cross: ("+u+","+v+")");
                }
            }
        }
        color[u]=VertexColor.BLACK;
        time+=1;
        finished[u]=time;
        list.addFirst(u);
    }
}
