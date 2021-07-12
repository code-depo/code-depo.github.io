import java.util.*;

class insertion_sort {
    public Vector<Integer> Insertion_sort(Vector<Integer> list){
        int n = list.size();
        for (int i=1; i<n; i++){
            int temp = list.get(i);
            int j = i-1;
            while(j>=0 && list.get(j)>temp){  //shifting all he larger ints to right
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, temp);         //putting the ith int in correct position 
        }
        return list;
    }
}
