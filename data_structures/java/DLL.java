class node<obj>{
	node<obj> next;
    node<obj> prev;
	obj data;
	node(node<obj> n,node<obj> p, obj a){
		next = n;
        prev = p;
		data = a;
	}
	void setnext(node<obj> n){
		next = n;
	}
	void setele(obj a){
		data = a;
	}
    void setprev(node<obj> p){
        prev = p;
    }
	obj getele(){
		return data;
	}
	node<obj> getnext(){
		return next;
	}
    node<obj> getprev(){
        return prev;
    }
}

class DLL<obj>{//does not have sentinal nodes
	/*note this is a generic class to use it, the declaration will be
	DLL<Object(eg - Integer/String..)> Q = new DLL<Object>();
	*/
	private node<obj> first;    //also called head
    private node<obj> last;     //also called tail
	private int size;
	DLL(){
		first = null;
        last = null;
		size=0;
	}
	void insertFirst(obj c){
		node<obj> n = new node<obj>(first,null, c);
        if(first != null){ first.setprev(n); }
		first=n;
        if(size==0){
            last = n;
        }
		this.size++;
	}
    void insertLast(obj c){
        node<obj> n = new node<obj>(null, last, c);
        if(last != null) { last.setnext(n); }
        last = n;
        if(size == 0){//if first element then first and last are the same
            first = n;
        }
        this.size++;
    }
	void removeFirst() throws NullPointerException{
		if(this.size == 0){
			throw new NullPointerException("DLL empty, cant remove");
		}
		first = first.getnext();
        if(first != null){ first.setprev(null); }
		this.size--;
		return;
	}
    void removeLast() throws NullPointerException{
        if(size==0){
            throw new NullPointerException("DLL empty, cant remove");
        }
        last = last.getprev();
        if (last != null){ last.setnext(null); }
        this.size--;
        return;
    }
	Object get(int i) throws IndexOutOfBoundsException{
		if(i>=size || i<0){
			throw new IndexOutOfBoundsException();
		}else if(i<size/2){		//start from first
			node<obj> temp = first;
			for (int j=0; j<i; j++){
				temp=temp.next;
			}
			return temp.data;
		}else{			//start from end
			node<obj> temp = last;
			int j = size-1;
			while(j != i){
				temp=temp.prev;
				j--;
			}
			return temp.data;
		}
	}
	node<obj> getNext(node<obj> Current){
		return Current.next;
	}
    node<obj> getPrev(node<obj> Current){
        return Current.prev;
    }
	int size(){
		return this.size;
	}
	void insert(int posi, obj d) throws IndexOutOfBoundsException{
		if(posi>size){
			throw new IndexOutOfBoundsException("index for insert is greater then size");
		}else if(posi<0){
			throw new IndexOutOfBoundsException("index for insert is negative");
		}
		node<obj> n = new node<obj>(null,null, d);
		node<obj> temp;
		if(posi<=size/2){
			if(posi == 0 ){
				insertFirst(d);
				return;
			}
			temp = first;
			while(posi>1){
				temp=temp.next;
				posi--;
			}
		}else{
			if(posi == size){
				insertLast(d);
				return;
			}
			temp = last;
			while(posi<size){
				temp=temp.prev;
				posi++;
			}
		}
		n.next = temp.next;
		temp.next.prev = n;
		temp.next = n;
		n.prev = temp;
		this.size++;
		return;
	}
	boolean remove(obj d){//removes the first obj with data = d
		node<obj> temp = first;
		for(int i=0; i<size; i++){
			if(temp.data == d){
				break;
			}
			temp = temp.next;
		}
		if(temp == first){
			removeFirst();
			return true;
		}else if(temp == last){
			removeLast();
			return true;
		}
		else if(temp!=null){
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			temp=null;
			size--;
			return true;
		}
		return false;
	}
	void del(int posi) throws IndexOutOfBoundsException{
		if(posi>=size || posi<0){
			throw new IndexOutOfBoundsException();
		}
		if(posi==0){
			removeFirst();
			return;
		}else if(posi == size-1){
			removeLast();
			return;
		}
		node<obj> temp = first;
		while(posi>0){
			temp=temp.next;
			posi--;
		}
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp=null;
		size--;
		return;
	}
	int find(obj d){//returns the 0 based index in the of first ocuurence of obj d, else -1
		node<obj> temp = first;
		for(int i=0; i<size; i++){
			if(temp.data == d){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
    void traverse(){
        node<obj> temp = first;
        for (int i=0;i<size;i++){
            System.out.println(temp.getele());
            temp = temp.getnext();
        }
    }
}