import java.util.Scanner;

import DFS.DFS;
import Graph.DirectedGraph;

public class Main{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int d=scn.nextInt();
        DirectedGraph g=new DirectedGraph(n);
        for(int i=0;i<d;i++){
            int u=scn.nextInt()-1;
            int v=scn.nextInt()-1;
            g.addEdge(u, v);
        }
        DFS.solve(g);
    }

    public static void f(int [] a){
        a[0]=100;
    }

}