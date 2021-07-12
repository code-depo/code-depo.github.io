#include <vector>
#include <cstdlib>
#include <time.h>
#include <iostream>
#include <string>
using namespace std;

vector<int> selection_sort(vector<int> list){
    int n = list.size();
    for(int p =0; p<n; p++){
        int Min=p;
        for (int i=p; i<n; i++){
            if(list[i]<list[Min]){
                Min = i;
            }
        }
        int temp = list[p];
        list[p]=list[Min];
        list[Min]=temp;
    }
    return list;
}

vector<int> bubble_sort(vector<int> list){
    int n = list.size();
    for (int i=0; i<n; i++){
        for(int j=1; j<n-i; j++){
            if(list[j] < list[j-1]){
                int temp = list[j-1];
                list[j-1] = list[j];
                list[j] = temp;
            }
        }
    }
    return list;
}

vector<int> insertion_sort(vector<int> list){
    int n = list.size();
    for(int i=1; i<n; i++){
        int temp = list[i];
        int j = i-1;
        while(j>=0 && (list[j] > temp)){
            list[j+1] = list[j];
            j--;
        }
        list[j+1]=temp;
    }
    return list;
}

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

vector<int> quick_sort(vector<int> list){
    int n = list.size();
    if(n<2){return list;}
    int mid = rand()%n;
    int head = 0;
    int tail = n-1;
    int p = list[mid];
    while (head<tail){  //partition
        while ((list[head]<p || head == mid) && head<tail){
            head++;
        }
        while((list[tail]>p || tail==mid) && head<tail){
            tail--;
        }
        if(head == tail){ break; }
        int temp = list[tail];
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
    int temp=list[mid]; //placing the pivot at it's sorted position
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

vector<int> Heapify(vector<int> l){
    int n = l.size();
    int done = n-1;
    while(done >= 0){
        int ptr = done;
        while(2*ptr+2 < n){
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
        int temp = list[0];
        list[0] = list[end];
        list[end] = temp;
        int ptr=0;
        while(2*ptr+2 < end){
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
    return list;
}

int power(int x, int y){
    int s=1;
    for (int i=0; i<y; i++){
        s = s*x;
    }
    return s;
}

string times(string s, int n){
    string res = "";
    for (int i=0; i<n; i++){
        res += s;
    }
    return res;
}

int bitstr2int(string s){
    int n=0;
    int size = s.length();
    int posi = 0;
    while(posi < size){
        n += stoi(s.substr(posi, 1))*(power(2, (size-posi-1)));
        posi++;
    }
    return n;
}

string int2bitstr(int n){
    string s = "";
    while(n>0){
        s = to_string(n%2) + s;
        n = n/2;
    }
    return s;
}

vector<int> radix_sort(vector<int> list){
    vector<string> strlist;
    int n = list.size();
    int max = 0;
    for (int i=0; i<n; i++){
        string s = int2bitstr(list[i]);
        if(s.size() > max){
            max = s.size();
        }
        strlist.push_back(s);
    }
    for (int i=0; i<n; i++){
        strlist[i] = times("0", max - strlist[i].size()) + strlist[i];
    }
    int ptr = max-1;
    vector<string> zero;
    vector<string> ones;
    while (ptr >= 0){
        zero.clear();
        ones.clear();
        for (int i=0; i<n; i++){
            if (strlist[i][ptr] == '0'){
                zero.push_back(strlist[i]);
            }else{
                ones.push_back(strlist[i]);
            }
        }
        zero.insert(zero.end(), ones.begin(), ones.end() );
        strlist = zero;
        ptr--;
    }
    for (int i=0; i<n; i++){
        list[i] = bitstr2int(strlist[i]);
    }
    return list;
}

int main(){
    vector<int> list;
    srand(2);
    for (int i=0; i<30; i++){
        int j=rand()%30;
        list.push_back(j);
        cout<<j<<',';
    }
    cout<<'\n';
    list = merge_sort(list);
    for (int i=0; i<30; i++){
        cout<<list[i]<<',';
    }
    cout<<'\n';
    
   //cout<< times("0",10)<<'\n';
}