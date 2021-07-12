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

class queue<obj>{//queue is nothing but a DLL with strict FIFO order
	/*note this is a generic class to use it, the declaration will be
	queue<Object(eg - Integer/String..)> Q = new queue<Object>();
	*/
	private node<obj> last;
    private node<obj> first;
	private int size;
	queue(){
		last = null;
        first = null;
		size=0;
	}
	void enqueue(obj c){
		node<obj> n = new node<obj>(last,null, c);
        if(last != null){ last.setprev(n); }
		last=n;
        if(size==0){
            first = n;
        }
		this.size++;
	}
    Object dequeue() throws NullPointerException{
        if(size==0){
            throw new NullPointerException("queue empty, cant remove");
        }
		node<obj> temp = first;
        first = first.getprev();
        if (first != null){ first.setnext(null); }
        this.size--;
        return temp;
    }
	Object getlast() throws NullPointerException{
		if(this.size == 0){
			throw new NullPointerException("queue empty");
		}
		return last.getele();
	}
    Object getfirst() throws NullPointerException{
		if(this.size == 0){
			throw new NullPointerException("queue empty");
		}
		return first.getele();
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
    void traverse(){
        node<obj> temp = first;
        for (int i=0;i<size;i++){
            System.out.println(temp.getele());
            temp = temp.prev;
        }
    }
}