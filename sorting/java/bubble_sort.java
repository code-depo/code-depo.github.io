import java.util.*;

class bubble_sort {
    public Vector<Integer> Bubble_sort(Vector<Integer> list){
        int n = list.size();
        for (int i=0; i<n; i++){
            for (int j=1; j<n-i; j++){          //if right int is greater then swap it untill a larger element is reached
                if(list.get(j) < list.get(j-1)){//the large ints get accumulated to the right thus we need to check only till n-i
                    int temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
}
