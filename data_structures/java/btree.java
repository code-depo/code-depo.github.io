import java.util.*;
class tnode{
    tnode left;
    tnode right;
    tnode parent;
    int data;
    int size;
    tnode(int d, tnode left, tnode rit, tnode parent){
        this.data = d;
        this.left = left;
        this.right = rit;
        this.parent = parent;
        size = 1;
    }
}

public class btree {
	tnode root;
	btree(int d){
		root = new tnode(d,null,null,null);
	}
	void add(int d) {//if the root of the subtree is equal to d then it is put to right
			tnode temp=root;
			while(true) {
                temp.size++;
				if(d<temp.data && temp.left!=null) {
					temp=temp.left;
				}else if(d<temp.data && temp.left==null) {
					tnode t=new tnode(d,null,null,temp);
					temp.left=t;
					break;
				}else if(d>=temp.data && temp.right!=null) {
					temp=temp.right;
				}else if(d>=temp.data && temp.right==null) {
					tnode t=new tnode(d,null,null,temp);
					temp.right=t;
					break;
				}
			}
			
	}
    boolean remove(int d){
        tnode temp = root;
        while(true){
            if(d == temp.data){
                break;
            }
            else if(temp.left!=null && d<temp.data){
                temp = temp.left;
            }else if(d>=temp.data && temp.right != null){
                temp = temp.right;
            }else if(temp.left==null && temp.right==null){
                return false;
            }
        }
        if(temp.data == d){
			if(temp.right==null && temp.left==null){
				if(temp.parent.left==temp){temp.parent.left=null;}
				else{temp.parent.right = null;}
			}else if(temp.left!=null && temp.right==null){
				if(temp!=root && temp.parent.left==temp){
                    temp.parent.left=temp.left;
                }else if(temp!=root && temp.parent.right==temp){
                    temp.parent.right=temp.left;
                }
                temp.left.parent=temp.parent;
				temp = null;
			}else if(temp.right!=null && temp.left==null){
				if(temp!=root && temp.parent.left==temp){
                    temp.parent.left=temp.right;
                }else if(temp!=root && temp.parent.right==temp){
                    temp.parent.right=temp.right;
                }
                temp.right.parent=temp.parent;
				temp = null;
			}else{
				tnode t2 = temp.right;
				while(t2.left!=null){t2 = t2.left;}	//finding the successor and replacing it with temp
				temp.data = t2.data;
				if(t2.right!=null){					//delecting the successor node
					if(t2.parent.left==t2){
						t2.parent.left=t2.right;
					}else if(t2.parent.right==t2){
						t2.parent.right=t2.right;
					}
					t2.right.parent=t2.parent;
				}else{
					if(t2.parent.left==t2){ t2.parent.left=null;}
					else{t2.parent.right = null;}
				}
				while(t2.parent!=null){t2=t2.parent; t2.size--;}
				t2 = null; temp=null;
				return true;
			}
			while(temp.parent!=null){temp = temp.parent; temp.size--;}
			temp=null;
			return true;
        }
        return false;
    }
	tnode find(int d){		//finds the tnode with data == d, least depth
		tnode temp = root;
		while(temp.data!=d){
			if(temp.data>d){
				if(temp.left!=null){temp = temp.left;}
				else{return null;}
			}else{
				if(temp.right!=null){temp=temp.right;}
				else{return null;}
			}
		}
		return temp;
	}
	void preorder(tnode t) {//note root must be passed as argument eg - preorder(tree.root)
		if(t==null) {
			return;
		}else {
			System.out.print(t.data+",");
			preorder(t.left);
			preorder(t.right);
		}
	}
	void postorder(tnode t) {
		if (t==null) {
			return;
		}else {
			postorder(t.left);
			postorder(t.right);
			System.out.print(t.data+",");
		}
	}
	void inorder(tnode t) {
		if (t==null) {
			return;
		}else {
			inorder(t.left);
			System.out.print(t.data+",");
			inorder(t.right);
		}
	}
	void levelorder(tnode t) {
		Vector<tnode> v=new Vector<tnode>();
		v.add(t);
		Vector<Integer> w=new Vector<Integer>();
			while(v.isEmpty()==false) {
				tnode temp=v.firstElement();
				if(temp.left!=null) {
					v.add(temp.left);
				}
				if(temp.right!=null) {
					v.add(temp.right);
				}
				w.add(temp.data);
				v.remove(0);
			}
		int n=w.size();
		for(int i=0;i<n;i++) {
			System.out.print(w.get(i)+" ");
		}
			
	}
	int size(){
		return root.size;
	}
}