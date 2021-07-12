import java.util.*;

class heap_sort {
    public Vector<Integer> Heapify(Vector<Integer> l){//making a heap list of any list 
        int n = l.size();
        int done = n-1;     //start from bottom right-most child
        while(done >= 0){
            int ptr = done;
            while(2*ptr+2 < n){//move the int to the bottom untill both its children are >= to itself
                if(l.get(2*ptr+2) < l.get(ptr) && l.get(2*ptr+2)<l.get(2*ptr+1)){
                    int temp = l.get(ptr);
                    l.set(ptr, l.get(2*ptr+2));
                    l.set(2*ptr+2, temp);
                    ptr = 2*ptr+2;
                }else if(l.get(2*ptr+1)<l.get(ptr)){
                    int temp = l.get(ptr);
                    l.set(ptr, l.get(2*ptr+1));
                    l.set(2*ptr+1, temp);
                    ptr = 2*ptr+1;
                }else { break;}
            }
            if(2*ptr+1<n && l.get(2*ptr+1)<l.get(ptr)){
                int temp = l.get(ptr);
                l.set(ptr, l.get(2*ptr+1));
                l.set(2*ptr+1, temp);
            }
            done--;
        }
        return l;
    }
    public Vector<Integer> Heap_sort(Vector<Integer> list){
        int n = list.size();
        list = Heapify(list);
        int end = n-1;
        while(end>0){
            int temp = list.get(0);     //swap the bottom right-most element with the root(smallest)
            list.set(0, list.get(end));
            list.set(end, temp);
            int ptr=0;
            while(2*ptr+2 < end){//heapify ignoring the sorted end of list by moving the swapped element to the right position
                if(list.get(2*ptr+2) < list.get(2*ptr+1) && list.get(2*ptr+2)<list.get(ptr)){
                    temp = list.get(ptr);
                    list.set(ptr, list.get(2*ptr+2));
                    list.set(2*ptr+2, temp);
                    ptr = 2*ptr+2;
                }
                else if(list.get(2*ptr+1)<list.get(ptr)){
                    temp = list.get(ptr);
                    list.set(ptr, list.get(2*ptr+1));
                    list.set(2*ptr+1, temp);
                    ptr = 2*ptr+1;
                }
                else{break;}
            }
            if(2*ptr+1<end && list.get(2*ptr+1)<list.get(ptr)){
                temp = list.get(ptr);
                list.set(ptr, list.get(2*ptr+1));
                list.set(2*ptr+1, temp);
            }
            end--;
        }
        return list;//finally we get a reverse sorted list which can be reversed if required.
    }
}
