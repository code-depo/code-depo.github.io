#include <vector>
using namespace std;

vector<int> selection_sort(vector<int> list){  
    int n = list.size();
    for(int p =0; p<n; p++){
        int Min=p;
        for (int i=p; i<n; i++){        //finding the minimum in the unsorted part by linear search
            if(list[i]<list[Min]){
                Min = i;
            }
        }
        int temp = list[p];         //swapping the min to end of sorted part
        list[p]=list[Min];
        list[Min]=temp;
    }
    return list;
}