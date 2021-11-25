package Graph;

public class Edge {
    int from;
    int to;
    double weight;
    public Edge(int from,int to,double weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
    }
    public Edge(int from,int to){
        this.from=from;
        this.to=to;
        this.weight=0.0;
    }

}
