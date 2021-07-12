#include <vector>
#include <cstdlib>
#include <string>
using namespace std;
/* note this is only for +ve integer
 can be extended to signed by comparing the first bit
 and applying to the -ve, +ve numbers seperately*/

int power(int x, int y){        //function for x^y
    int s=1;
    for (int i=0; i<y; i++){
        s = s*x;
    }
    return s;
}

string times(string s, int n){    //function for string repeatition
    string res = "";
    for (int i=0; i<n; i++){
        res += s;
    }
    return res;
}

int bitstr2int(string s){       //function to convert unsigned bitstring to integer
    int n=0;
    int size = s.length();
    int posi = 0;
    while(posi < size){
        n += stoi(s.substr(posi, 1))*(power(2, (size-posi-1)));
        posi++;
    }
    return n;
}

string int2bitstr(int n){       //function to convert +ve int to unsigned bitstring
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
    for (int i=0; i<n; i++){            //converting the int list to bitstr list
        string s = int2bitstr(list[i]);
        if(s.size() > max){
            max = s.size();
        }
        strlist.push_back(s);
    }
    for (int i=0; i<n; i++){
        strlist[i] = times("0", max - strlist[i].size()) + strlist[i];//making all bitstr to the same length
    }
    int ptr = max-1;
    vector<string> zero;
    vector<string> ones;
    while (ptr >= 0){       //starting from right most bit doing stable partition of bitstr list
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
    for (int i=0; i<n; i++){        //converting the bit str to int
        list[i] = bitstr2int(strlist[i]);
    }
    return list;
}