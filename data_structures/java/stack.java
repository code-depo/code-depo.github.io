class node<obj>{
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
class stack<obj>{
	private node<obj> top;
	private int size;
	stack(){
		top = new node<obj>(null, null);//sentinel node
		size=0;
	}
	void push(obj c){
		node<obj> n = new node<obj>(top, c);
		top=n;
		this.size++;
	}
	Object pop() throws NullPointerException{
		if(this.size == 0){
			throw new NullPointerException("Stack empty nothing to pop");
		}
		Object d = top.getele();
		top = top.getnext();
		this.size--;
		return d;
	}
	Object top() throws NullPointerException{
		if(this.size == 0){
			throw new NullPointerException("Stack empty");
		}
		return top.getele();
	}
	node<obj> getnext(){
		return top.next;
	}
	int size(){
		return this.size;
	}
}

