#include <vector>
using namespace std;

vector<int> bubble_sort(vector<int> list){
    int n = list.size();
    for (int i=0; i<n; i++){
        for(int j=1; j<n-i; j++){       //if right int is greater then swap it untill a larger element is reached
            if(list[j] < list[j-1]){    //the large ints get accumulated to the right thus we need to check only till n-i
                int temp = list[j-1];
                list[j-1] = list[j];
                list[j] = temp;
            }
        }
    }
    return list;
}