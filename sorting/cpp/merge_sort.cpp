#include <vector>
using namespace std;

vector<int> merge(vector<int> list1, vector<int> list2){
    int n1 = list1.size();
    int n2 = list2.size();
    int p1=0;
    int p2=0;
    vector<int> merged_list;
    while(p1<n1 && p2<n2){
        if(list1[p1] < list2[p2]){
            merged_list.push_back(list1[p1]);
            p1++;
        }else{
            merged_list.push_back(list2[p2]);
            p2++;
        }
    }
    if(p1<n1){
        merged_list.insert(merged_list.end(), list1.begin()+p1, list1.end() );
    }
    else if(p2<n2){
        merged_list.insert(merged_list.end(), list2.begin()+p2, list2.end() );
    }
    return merged_list;
}

vector<int> merge_sort(vector<int> list){
    int n = list.size();
    if(n <= 1){ return list;}
    vector<int> v1 = merge_sort(vector<int>(list.begin(), list.begin()+n/2));
    vector<int> v2 = merge_sort(vector<int>(list.begin()+n/2, list.end()));
    return merge(v1,v2);
}