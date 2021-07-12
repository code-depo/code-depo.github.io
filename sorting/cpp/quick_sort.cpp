#include <vector>
#include <cstdlib>      //required for random number
using namespace std;

vector<int> quick_sort(vector<int> list){
    int n = list.size();
    if(n<2){return list;}       //base case 0 or 1 element, can be another sort algo
    int mid = rand()%n;         //picking a random pivot
    int head = 0;
    int tail = n-1;
    int p = list[mid];
    while (head<tail){  //partition
        while ((list[head]<p || head == mid) && head<tail){//searching for an element in LHS >= pivot
            head++;
        }
        while((list[tail]>p || tail==mid) && head<tail){//searching for an element in LHS <= pivot
            tail--;
        }
        if(head == tail){ break; }
        int temp = list[tail];          //swap
        list[tail] = list[head];
        list[head] = temp;
        if(tail - head >1){
            tail--;
            head++;
        }else if(head<mid){
            head++;
        }else if(head>mid){
            tail--;
        }
    }
    if(mid<head && list[head]>=p){ head--;}
    else if(mid>head && list[head]<=p){ head++;}
    int temp=list[mid];                 //placing the pivot at it's sorted position
    list[mid] = list[head];
    list[head]=temp;
    if(head == n-1){
        vector<int> v1 = quick_sort(vector<int>(list.begin(), list.begin()+head));
        v1.push_back(p);
        return v1;
    }
    vector<int> v1 = quick_sort(vector<int>(list.begin(), list.begin()+head));
    vector<int> v2 = quick_sort(vector<int>(list.begin()+head+1, list.end()));
    v1.push_back(p);
    v1.insert(v1.end(), v2.begin(), v2.end() );
    return v1;
}