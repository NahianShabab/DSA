package DFS;

import java.util.LinkedList;

import Graph.DirectedGraph;

public class DFS {
    enum Color{
        WHITE,GREY,BLACK
    };
    public static void solve(DirectedGraph g){
        DepthSearch(g);
    }

    public static void DepthSearch(DirectedGraph g){
        int v=g.vertices;
        Color c[]=new Color[v];
        int pred[]=new int[v];
        for(int i=0;i<v;i++){
            c[i]=Color.WHITE;
            pred[i]=-1;
        }
        int timer=0;
        LinkedList l=new LinkedList<Integer>();
        for(int i=0;i<v;i++){
            if(c[i]==Color.WHITE){
                DepthVisit(c, pred, g, timer, i,l);
            }
        }
        for(int i=l.size()-1;i>=0;i--){
            int j=(int)l.get(i)+1;
            System.out.print(j+" ");
        }
    }

    public static void DepthVisit(Color c[],int pred[],DirectedGraph g,int timer,int u,LinkedList list){
        c[u]=Color.GREY;
        for(int i=0;i<g.adjacencyLists[u].size();i++){
            if(c[g.adjacencyLists[u].get(i)]==Color.WHITE){
                DepthVisit(c, pred, g, timer, g.adjacencyLists[u].get(i), list);
            }
            else if(c[g.adjacencyLists[u].get(i)]==Color.GREY){
                System.out.println("not possible");
                System.exit(0);
            }
        }
        c[u]=Color.BLACK;
        list.addFirst(u);
    }
}
