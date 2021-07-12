class node<obj>{//note this is a generic class
	node<obj> next;
	obj data;
	node(node<obj> n, obj a){
		next = n;
		data = a;
	}
	void setnext(node<obj> n){
		next = n;
	}
	void setele(obj a){
		data = a;
	}
	obj getele(){
		return data;
	}
	node<obj> getnext(){
		return next;
	}
}
class SLL<obj>{
	/*note this is a generic class to use it, the declaration will be
	SLL<Object(eg - Integer/String..)> Q = new SLL<Object>();
	*/
	private node<obj> head;
	private int size;
	SLL(){
		head = null;//sentinel node
		size=0;
	}
	void insertFirst(obj c){
		node<obj> n = new node<obj>(head, c);
		head=n;
		this.size++;
	}
	void removeFirst() throws NullPointerException{
		if(this.size == 0){
			throw new NullPointerException("SLL empty nothing to pop");
		}
		head = head.getnext();//the prev will be collected by garbage collector
		this.size--;		//since it has no pointer to it
		return;
	}
	node<obj> getNext(node n){
		return n.next;
	}
	int size(){
		return this.size;
	}
	Object get(int i) throws IndexOutOfBoundsException{//returns the obj at index i
		if(i>=size || i<0){
			throw new IndexOutOfBoundsException();
		}
		node<obj> temp = head;
		for (int j=0; j<i; j++){
			temp=temp.next;
		}
		return temp.data;
	}
	void insert(int posi, obj d) throws IndexOutOfBoundsException{//inserts the node at a particular index, throws error if index out of bound.
		if(posi>size){
			throw new IndexOutOfBoundsException("index for insert is greater then size");
		}else if(posi<0){
			throw new IndexOutOfBoundsException("index for insert is negative");
		}
		//0<= posi <= size. when equal to size insert a last.
		if(posi == 0 ){
			insertFirst(d);
			return;
		}
		node<obj> temp = head;
		node<obj> n = new node<obj>(head, d);
		while(posi>1){
			temp=temp.next;
			posi--;
		}
		n.next = temp.next;
		temp.next = n;
		this.size++;
		return;
	}
	void del(int posi) throws IndexOutOfBoundsException{
		if(posi>=size || posi<0){
			throw new IndexOutOfBoundsException();
		}
		if(posi==0){
			removeFirst();
			return;
		}
		node<obj> temp = head;
		node<obj> temp_prev = null;
		while(posi>0){
			temp_prev = temp;
			temp=temp.next;
			posi--;
		}
		temp_prev.next = temp.next;
		temp.next = null;
		size--;
		return;
	}
	int find(obj d){//returns the 0 based index in the of first ocuurence of obj d, else -1
		node<obj> temp = head;
		for(int i=0; i<size; i++){
			if(temp.data == d){
				return i;
			}
			temp = temp.next;
		}
		return -1;
	}
	boolean remove(obj d){//removes the first node with 'd' if exists
		node<obj> temp = head;
		node<obj> temp_prev = null;
		for(int i=0; i<size; i++){
			if(temp.data == d){
				break;
			}
			temp_prev = temp;
			temp = temp.next;
		}
		if(temp == head){
			removeFirst();
			return true;
		}else if(temp!=null){
			temp_prev.next = temp.next;
			size--;
			return true;
		}
		return false;
	}
}
