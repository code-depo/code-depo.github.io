import java.util.*;
public class Heap{  //the scope of the functions if friendly you can change it as required
    ArrayList<Integer> heap = new ArrayList<Integer>();
    void add(int d){
        heap.add(d);
        int ptr = heap.size()-1;
        while(ptr>0 && heap.get((ptr-1)/2)>heap.get(ptr)){ //subtraction done 'coz' of 0 indexing
            int temp = heap.get(ptr);       //eg - 0 has 1,2 as chlid 
            heap.set(ptr, heap.get( (ptr-1)/2 ) );   //hence (1-1)/2=0, (2-1)/2=0 mapping
            heap.set((ptr-1)/2, temp);
            ptr = (ptr-1)/2;
        }
        return;
    }
    int find(int d){//returns first index if exists else -1
        int n = heap.size();
        for (int i=0; i<n; i++){
            if(heap.get(i) == d){
                return i;
            }
        }
        return -1;
    }
    boolean remove(int d){//linear s
        int ptr  = this.find(d);
        if(ptr!=-1){
            int last = heap.size()-1;
            heap.set(ptr, heap.get(last));
            heap.remove(last);
            Heapify(ptr);
            return true;
        }
        return false;
    }
    void Heapify(int ptr){
        /*swaps the large element at ptr
         with smaller child untill heap is formed*/
        int n = heap.size();
        while(2*ptr+2 < n){     //move the int to the bottom untill both its children are >= to itself
            if(heap.get(2*ptr+2) < heap.get(ptr) && heap.get(2*ptr+2)<heap.get(2*ptr+1)){
                int temp = heap.get(ptr);
                heap.set(ptr, heap.get(2*ptr+2));
                heap.set(2*ptr+2, temp);
                ptr = 2*ptr+2;
            }else if(heap.get(2*ptr+1)<heap.get(ptr)){
                int temp = heap.get(ptr);
                heap.set(ptr, heap.get(2*ptr+1));
                heap.set(2*ptr+1, temp);
                ptr = 2*ptr+1;
            }else { break;}
        }
        if(2*ptr+1<n && heap.get(2*ptr+1)<heap.get(ptr)){
            int temp = heap.get(ptr);
            heap.set(ptr, heap.get(2*ptr+1));
            heap.set(2*ptr+1, temp);
        }
        return;
    }
    void makeHeap(ArrayList<Integer> list){
        heap = list;
        int n=heap.size();
        int done = n-1;
        while(done>=0){
            Heapify(done);
            done--;
        }
        /*making heaps bottom up:
        each of the left, right subtree will be heap at
        pointer 'done'. The violation at 'done' is rectified
        by Heapify(done). Thus, making the subtree rooted
        at 'done' heap. move 'done' left then upwards.
        */
        return;
    }
    int size(){
        return heap.size();
    }
}