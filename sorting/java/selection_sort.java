import java.util.*;

class selection_sort {
    public Vector<Integer> Selection_sort(Vector<Integer> list){
        int n = list.size();
        for (int p=0; p<n; p++){
            int Min = p;
            for (int i=p; i<n; i++){
                if(list.get(i)<list.get(Min)){//find the index of smallest element
                    Min = i;
                }
            }
            int temp = list.get(p);     //swapping the min to end of sorted part
            list.set(p, list.get(Min));
            list.set(Min, temp);
        }
        return list;
    }
}
