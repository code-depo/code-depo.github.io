import java.util.*;

class Quick_sort {
    public Vector<Integer> add_vec(Vector<Integer> v1, Vector<Integer> v2){ //function for adding two vectors
        Collection c = v2.subList(0, v2.size());
        v1.addAll(c);
        return v1;
    }

    public Vector<Integer> splice(Vector<Integer> v1,int from,int till){//function for splicing a vector
        Collection c = v1.subList(from, till);
        Vector<Integer> spliced = new Vector<Integer>();
        spliced.addAll(c);
        return spliced;
    }

    public Vector<Integer> quick_sort(Vector<Integer> list){//actual quick sort function
        int n = list.size();
        if(n<2){return list;}           //base case 0 or 1 element, can be another sort algo
        int mid = (int)(Math.random()*n);//picking a random pivot
        int head = 0;
        int tail = n-1;
        int p = list.get(mid);
        while(head<tail){//partition
            while ((list.get(head)<p || head==mid) && head<tail){//searching for an element in LHS >= pivot
                head++;
            }
            while((list.get(tail)>p || tail==mid) && head<tail){//searching for an element in LHS <= pivot
                tail--;
            }
            if(head == tail){ break; }
            int temp = list.get(tail);      //swap
            list.set(tail, list.get(head));
            list.set(head, temp);
            if(tail - head >1){
                tail--;
                head++;
            }else if(head<mid){
                head++;
            }else if(head>mid){
                tail--;
            }
        }
        if(mid<head && list.get(head)>=p){head--;}
        else if(mid>head && list.get(head)<=p){head++;}
        int temp = list.get(mid);                       //placing the pivot at it's sorted position
        list.set(mid, list.get(head));
        list.set(head, temp);
        Vector<Integer> v1 = quick_sort(splice(list, 0, head));
        v1.add(p);
        if(head == n-1){
            return v1;
        }
        Vector v2 = quick_sort(splice(list, head+1, n));
        add_vec(v1, v2);
        return v1;
    }
}
