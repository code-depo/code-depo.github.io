#include <vector>
using namespace std;

vector<int> insertion_sort(vector<int> list){
    int n = list.size();
    for(int i=1; i<n; i++){
        int temp = list[i];
        int j = i-1;
        while(j>=0 && (list[j] > temp)){    //shifting all he larger ints to right
            list[j+1] = list[j];            
            j--;
        }
        list[j+1]=temp;                     //putting the ith int in correct position 
    }
    return list;
}