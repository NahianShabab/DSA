#ifndef HEAP_H_INCLUDED
#define HEAP_H_INCLUDED
#include<vector>

class Heap{
private:
    void swap(int & a,int & b){
        int temp=a;
        a=b;
        b=temp;
    }
    int lastIndex;
    int capacity;
    int * arr;
public:
    Heap(int capacity){
        this->capacity=capacity+1;
        arr=new int[this->capacity];
        lastIndex=0;
    }
    Heap(const Heap & obj){
        this->capacity=obj.capacity;
        this->lastIndex=obj.lastIndex;
        arr=new int[this->capacity];
        for(int i=1;i<=obj.lastIndex;i++)
            arr[i]=obj.arr[i];
    }
    Heap & operator = (const Heap & obj){
        if(this->capacity<obj.capacity){
            delete [] arr;
            this->capacity=obj.capacity;
            arr=new int[this->capacity];
        }
        this->lastIndex=obj.lastIndex;
        for(int i=1;i<=obj.lastIndex;i++)
            arr[i]=obj.arr[i];
        return * this;
    }
    void insert(int value){
        if(lastIndex>=capacity)
            return;
        arr[++lastIndex]=value;
        int currentIndex=lastIndex;
        if(currentIndex!=1){
            int parentIndex;
            do{
                parentIndex=currentIndex/2;
                if(arr[parentIndex]<arr[currentIndex]){
                     swap(arr[parentIndex],arr[currentIndex]);
                }
                else
                    break;
                currentIndex=parentIndex;
            }while(currentIndex!=1);
        }
    }
    bool isEmpty()const {return lastIndex==0;}
    int size()const{return lastIndex;}
    int getMax() const {
        if(!isEmpty())
            return arr[1];
    }
    void deleteKey(){
        if(isEmpty())
            return;
        arr[1]=arr[lastIndex];
        lastIndex--;
        if(isEmpty())
            return;
        int currentIndex=1;
        do{
            int leftChild=2*currentIndex;
            int rightChild=leftChild+1;
            /*has no child */
            if(leftChild>lastIndex && rightChild>lastIndex)
                break;
            /*has both child*/
            else if(leftChild<=lastIndex && rightChild<=lastIndex){
                int greaterChild=arr[leftChild]>arr[rightChild]?leftChild:rightChild;
                if(arr[currentIndex]>arr[greaterChild])
                    break;
                else{
                    swap(arr[currentIndex],arr[greaterChild]);
                    currentIndex=greaterChild;
                }
            }
            /*has only left child*/
            else{
                if(arr[currentIndex]>arr[leftChild])
                    break;
                else{
                    swap(arr[currentIndex],arr[leftChild]);
                    currentIndex=leftChild;
                }
            }
        }while(currentIndex<lastIndex);
    }
    ~Heap(){
        delete [] arr;
    }

};

void heapsort (std::vector<int> & numbers){
    Heap h(numbers.size());
    for(int i=0;i<numbers.size();i++)
        h.insert(numbers.at(i));
    numbers.clear();
    while(!h.isEmpty()){
        numbers.push_back(h.getMax());
        h.deleteKey();
    }
}


#endif // HEAP_H_INCLUDED
