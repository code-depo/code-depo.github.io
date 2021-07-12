import java.util.*;

class Radix_sort {
    public int power(int x, int y){        //function for x^y
        int s=1;
        for (int i=0; i<y; i++){
            s = s*x;
        }
        return s;
    }
    public String times(String s, int n){   //function for string repeatition
        String res = "";
        for (int i=0; i<n; i++){
            res += s;
        }
        return res;
    }
    public int bitstr2int(String s){      //function to convert unsigned bitstring to integer
        int n = 0;
        int size = s.length();
        int posi = 0;
        int c;
        while(posi < size){
            c = s.charAt(posi);
            n += (c-48)*(power(2, size-posi-1));
            posi++;
        }
        return n;
    }
    public String int2strbit(int n){      //function to convert +ve int to unsigned bitstring
        String s = "";
        while(n>0){
            s = String.valueOf(n%2) + s;
            n = n/2;
        }
        return s;
    }
    Vector<Integer> radix_sort(Vector<Integer> list){
        int n = list.size();
        String[] strlist = new String[n];
        int max = 0;
        for (int i=0; i<n; i++){           //converting the int list to bitstr list
            String s = int2strbit(list.get(i));
            if(s.length() > max){
                max = s.length();
            }
            strlist[i]=s;
        }
        for (int i=0; i<n; i++){//making all bitstr to the same length
            strlist[i] =  times("0", max - strlist[i].length()) + strlist[i] ;
        }
        int ptr = max-1;
        Vector<String> zero = new Vector<String>();
        Vector<String> ones = new Vector<String>();
        while(ptr>=0){       //starting from right most bit doing stable partition of bitstr list
            zero.clear();
            ones.clear();
            for (int i=0; i<n; i++){
                if (strlist[i].charAt(ptr) == '0'){
                    zero.add(strlist[i]);
                }else{
                    ones.add(strlist[i]);
                }
            }
            int ones_size = ones.size();
            for (int j=0; j<ones_size; j++){
                zero.add(ones.get(j));
            }
            zero.copyInto(strlist);
            ptr--;
        }
        for (int i=0; i<n; i++){        //converting the bit str to int
            list.set(i, bitstr2int(strlist[i]));
        }
        return list;
    }
}
