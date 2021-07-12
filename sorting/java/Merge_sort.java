import java.util.*;

//note the function operates on the INTERFACE object List
class Merge_sort {
    public List<Integer> merge(List<Integer> list1, List<Integer> list2){
        int n1 = list1.size();
        int n2 = list2.size();
        int p1 = 0;
        int p2 = 0;
        List<Integer> merged_list = new Vector<Integer>();
        while(p1<n1 && p2<n2){
            if(list1.get(p1) < list2.get(p2)){
                merged_list.add(list1.get(p1));
                p1++;
            }else{
                merged_list.add(list2.get(p2));
                p2++;
            }
        }
        if(p1<n1){
            Collection c = list1.subList(p1,n1);
            merged_list.addAll(c);
        }else if(p2<n2){
            Collection c = list2.subList(p2,n2);
            merged_list.addAll(c);
        }
        return merged_list;
    }

    public List<Integer> merge_sort(List<Integer> list){
        int n = list.size();
        if( n<2 ){return list;}
        return merge(
            merge_sort(list.subList(0, n/2)), 
            merge_sort(list.subList(n/2, n))
            );
    }
}
