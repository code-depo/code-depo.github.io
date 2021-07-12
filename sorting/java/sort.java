import java.util.*;

class sort_fun{
    public Vector<Integer> selection_sort(Vector<Integer> list){
        int n = list.size();
        for (int p=0; p<n; p++){
            int Min = p;
            for (int i=p; i<n; i++){
                if(list.get(i)<list.get(Min)){
                    Min = i;
                }
            }
            int temp = list.get(p);
            list.set(p, list.get(Min));
            list.set(Min, temp);
        }
        return list;
    }
    public Vector<Integer> bubble_sort(Vector<Integer> list){
        int n = list.size();
        for (int i=0; i<n; i++){
            for (int j=1; j<n-i; j++){
                if(list.get(j) < list.get(j-1)){
                    int temp = list.get(j-1);
                    list.set(j-1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }
    public Vector<Integer> insertion_sort(Vector<Integer> list){
        int n = list.size();
        for (int i=1; i<n; i++){
            int temp = list.get(i);
            int j = i-1;
            while(j>=0 && list.get(j)>temp){
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, temp);
        }
        return list;
    }
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

    public Vector<Integer> add_vec(Vector<Integer> v1, Vector<Integer> v2){
        Collection c = v2.subList(0, v2.size());
        v1.addAll(c);
        return v1;
    }

    public Vector<Integer> splice(Vector<Integer> v1,int from,int till){
        Collection c = v1.subList(from, till);
        Vector<Integer> spliced = new Vector<Integer>();
        spliced.addAll(c);
        return spliced;
    }

    public Vector<Integer> quick_sort(Vector<Integer> list){
        int n = list.size();
        if(n<2){return list;}
        int mid = (int)(Math.random()*n);
        int head = 0;
        int tail = n-1;
        int p = list.get(mid);
        while(head<tail){//partition
            while ((list.get(head)<p || head==mid) && head<tail){
                head++;
            }
            while((list.get(tail)>p || tail==mid) && head<tail){
                tail--;
            }
            if(head == tail){ break; }
            int temp = list.get(tail);
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
        int temp = list.get(mid);
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
    public Vector<Integer> Heapify(Vector<Integer> l){
        int n = l.size();
        int done = n-1;
        while(done >= 0){
            int ptr = done;
            while(2*ptr+2 < n){
                if(l.get(2*ptr+2) < l.get(ptr) && l.get(2*ptr+2)<l.get(2*ptr+1)){
                    int temp = l.get(ptr);
                    l.set(ptr, l.get(2*ptr+2));
                    l.set(2*ptr+2, temp);
                    ptr = 2*ptr+2;
                }else if(l.get(2*ptr+1)<l.get(ptr)){
                    int temp = l.get(ptr);
                    l.set(ptr, l.get(2*ptr+1));
                    l.set(2*ptr+1, temp);
                    ptr = 2*ptr+1;
                }else { break;}
            }
            if(2*ptr+1<n && l.get(2*ptr+1)<l.get(ptr)){
                int temp = l.get(ptr);
                l.set(ptr, l.get(2*ptr+1));
                l.set(2*ptr+1, temp);
            }
            done--;
        }
        return l;
    }
    public Vector<Integer> heap_sort(Vector<Integer> list){
        int n = list.size();
        list = Heapify(list);
        int end = n-1;
        while(end>0){
            int temp = list.get(0);
            list.set(0, list.get(end));
            list.set(end, temp);
            int ptr=0;
            while(2*ptr+2 < end){
                if(list.get(2*ptr+2) < list.get(2*ptr+1) && list.get(2*ptr+2)<list.get(ptr)){
                    temp = list.get(ptr);
                    list.set(ptr, list.get(2*ptr+2));
                    list.set(2*ptr+2, temp);
                    ptr = 2*ptr+2;
                }
                else if(list.get(2*ptr+1)<list.get(ptr)){
                    temp = list.get(ptr);
                    list.set(ptr, list.get(2*ptr+1));
                    list.set(2*ptr+1, temp);
                    ptr = 2*ptr+1;
                }
                else{break;}
            }
            if(2*ptr+1<end && list.get(2*ptr+1)<list.get(ptr)){
                temp = list.get(ptr);
                list.set(ptr, list.get(2*ptr+1));
                list.set(2*ptr+1, temp);
            }
            end--;
        }
        return list;
    }
    public int power(int x, int y){
        int s=1;
        for (int i=0; i<y; i++){
            s = s*x;
        }
        return s;
    }
    public String times(String s, int n){
        String res = "";
        for (int i=0; i<n; i++){
            res += s;
        }
        return res;
    }
    public int bitstr2int(String s){
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
    public String int2strbit(int n){
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
        for (int i=0; i<n; i++){
            String s = int2strbit(list.get(i));
            if(s.length() > max){
                max = s.length();
            }
            strlist[i]=s;
        }
        for (int i=0; i<n; i++){
            strlist[i] =  times("0", max - strlist[i].length()) + strlist[i] ;
        }
        int ptr = max-1;
        Vector<String> zero = new Vector<String>();
        Vector<String> ones = new Vector<String>();
        while(ptr>=0){
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
        for (int i=0; i<n; i++){
            list.set(i, bitstr2int(strlist[i]));
        }
        return list;
    }
}

public class sort{
	public static void main(String args[]) {
        int n = 10000;
		Vector<Integer> list = new Vector<Integer>();
        // Vector must be changed to List for merge sort**
		for(int i=0;i<n;i++) {
			list.add( (int)(Math.random()*10000) );
            System.out.print(list.get(i)+", ");
		}
        System.out.println();
		sort_fun func = new sort_fun();
        long startTime = System.nanoTime();
		list = func.merge_sort(list);
        long stopTime = System.nanoTime();
		for(int i=0;i<n;i++) {
			System.out.print(list.get(i)+", ");
		}
        System.out.println();
        System.out.println(stopTime - startTime);
	}
}