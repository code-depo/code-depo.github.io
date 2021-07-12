#include <vector>
using namespace std;

vector<int> Heapify(vector<int> l){ //making a heap list of any list 
    int n = l.size();
    int done = n-1;         //start from bottom right-most child
    while(done >= 0){
        int ptr = done;
        while(2*ptr+2 < n){     //move the int to the bottom untill both its children are >= to itself
            if(l[2*ptr+2] < l[ptr] && l[2*ptr+2]<l[2*ptr+1]){
                int temp = l[ptr];
                l[ptr] = l[2*ptr+2];
                l[2*ptr+2] = temp;
                ptr = 2*ptr+2;
            }else if(l[2*ptr+1]<l[ptr]){
                int temp = l[ptr];
                l[ptr] = l[2*ptr+1];
                l[2*ptr+1] = temp;
                ptr = 2*ptr+1;
            }else { break;}
        }
        if(2*ptr+1<n && l[2*ptr+1]<l[ptr]){
            int temp = l[ptr];
            l[ptr] = l[2*ptr+1];
            l[2*ptr+1] = temp;
        }
        done--;
    }
    return l;
}

vector<int> heap_sort(vector<int> list){
    int n = list.size();
    list = Heapify(list);
    int end = n-1;
    while(end>0){
        int temp = list[0];     //swap the bottom right-most element with the root(smallest)
        list[0] = list[end];
        list[end] = temp;
        int ptr=0;
        while(2*ptr+2 < end){       //heapify ignoring the sorted end of list by moving the swapped element to the right position
            if(list[2*ptr+2] < list[2*ptr+1] && list[2*ptr+2]<list[ptr]){
                int temp = list[ptr];
                list[ptr] = list[2*ptr+2];
                list[2*ptr+2] = temp;
                ptr = 2*ptr+2;
            }
            else if(list[2*ptr+1] < list[ptr]){
                int temp = list[ptr];
                list[ptr] = list[2*ptr+1];
                list[2*ptr+1] = temp;
                ptr = 2*ptr + 1;
            }
            else{break;}
        }
        if(2*ptr+1 < end && list[2*ptr+1]<list[ptr]){
            int temp = list[ptr];
            list[ptr] = list[2*ptr+1];
            list[2*ptr+1] = temp;
        }
        end--;
    }
    return list;    //finally we get a reverse sorted list which can be reversed if required.
}