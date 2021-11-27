package DisjointSetLinkedList;

public class SetElement{
    //public
    public int data;
    public SetElement(int d){
        this.data=d;
    }
     public static class Set{
        public static void makeSet(SetElement e){
            if(e.set!=null){
                return;
            }
            e.set=new _Set(e,e);
        }
        public static SetElement findSet(SetElement e){
            if(e.set==null)
                return e;
            return e.set.head;
        }
        public static void union(SetElement e1,SetElement e2){
            makeSet(e1);
            makeSet(e2);
            if(findSet(e1)==findSet(e2))
                return;
            e1.set.tail.next=e2.set.head;
            e1.set.tail=e2.set.head;
            SetElement s=e2.set.head;
            while(s!=null){
                s.set=e1.set;
                s=s.next;
            }
        }
        public static void printSet(SetElement e){
            SetElement e1=findSet(e);
            while(e1!=null){
                System.out.println(e1.data);
                e1=e1.next;
            }
        }
    }

    //private
    private _Set set=null;
    private SetElement next=null;
    private static class _Set{
        public SetElement head=null;
        public SetElement tail=null;
        public _Set(SetElement head,SetElement tail){
            this.head=head;
            this.tail=tail;
        }
    }
   
}