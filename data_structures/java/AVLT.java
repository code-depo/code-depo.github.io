import java.util.*;

class tnode{
	tnode parent;
	tnode left;
	tnode right;
	int data;
	int height;
	tnode(int d, tnode left, tnode rit, tnode parent){
        this.data = d;
        this.left = left;
        this.right = rit;
        this.parent = parent;
    }
}

class AVLT{
    tnode root;
	int size;
    AVLT(int d){
        root = new tnode(d, null, null, null);
		size=1;
    }
    void insert(int d){
        tnode t = new tnode(d, null, null, null);
        tnode temp = root;
		size++;
        while (temp != null) {
            if (d < temp.data) {
                if (temp.left != null) {temp = temp.left;} 
                else if (temp.left == null) {
                    temp.left = t;
                    t.parent = temp;
                    if (temp.right == null) {
                        temp.height = 1;
                    }else if (temp.height == 1){
                        return;//balanced
                    }
                    break;
                }
            }else{//equal elements are preffered to the right
                if(temp.right!=null){temp = temp.right;}
                else if(temp.right == null){
                    temp.right = t;
                    t.parent = temp;
                    if(temp.left == null){
                        temp.height = 1;
                    }
                    else if(temp.height==1){
                        return;//balanced
                    }
                    break;
                }
            }
        }
        tnode x = null;
        tnode y = null;
        tnode z = null;
        while(temp!=null){
            if(temp.right==null && temp.left.height==1){
                z=temp;
                y=temp.left;
                if(y.left!=null){x = y.left;}
                else{x=y.right;}
                break;
            }else if(temp.left==null && temp.right.height==1){
				z=temp;
				y=temp.right;
				if(y.right!=null){x=y.right;}
				else{x=y.left;}
				break;
			}
    		else if( temp.left!=null && temp.right!=null && (Math.abs(temp.left.height-temp.right.height)>1) ){
    			z=temp;
    			if(temp.left.height>temp.right.height){
    				y=temp.left;
    			}else{y=temp.right;}
    			if(y.left.height>y.right.height){x=y.left;}
    			else{x=y.right;}
    			break;
    		}
    		if(temp.right!=null && temp.left!=null){
   				temp.height=Math.max(temp.left.height,temp.right.height)+1;
			}else if(temp.right==null || temp.left==null){temp.height=1;}
			temp=temp.parent;
        }
        if(x!=null && y!=null && z!=null){
            if(z.left==y && y.left==x){//right rotation
				if(z.parent!=null){
                	if(z.parent.right==z){z.parent.right=y;}
					else if(z.parent.left==z){z.parent.left=y;}
				}
                y.parent=z.parent;
                z.left=y.right;
                if(y.right!=null){
                    y.right.parent=z;
                }
                z.parent=y;
                y.right=z;
                if(z.left!=null && z.right!=null){
                    z.height=Math.max(z.left.height,z.right.height)+1;
                }
                else if(z.right!=null || z.left!=null){
                    z.height=1;
                }
                else{
                    z.height=0;
                }
                y.height=Math.max(z.height,x.height)+1;
            }else if(z.right==y && y.right==x){//left rotation
				if(z.parent!=null){
                	if(z.parent.right==z){z.parent.right=y;}
					else if(z.parent.left==z){z.parent.left=y;}
				}
                y.parent=z.parent;
                z.right=y.left;
                if(y.left!=null){y.left.parent=z;}
                z.parent=y;
                y.left=z;
                if(z.left!=null && z.right!=null){
                    z.height=Math.max(z.left.height,z.right.height)+1;
                }
                else if(z.left!=null || z.right!=null){
                    z.height=1;
                }
                else{z.height=0;}
                y.height=Math.max(z.height,x.height)+1;
            }else if(z.left==y && y.right==x){//double rotation (left, right)
				if(z.parent!=null){
                	if(z.parent.right==z){ z.parent.right=x;}
					else if(z.parent.left==z){ z.parent.left=x;}
				}
                x.parent=z.parent;
                y.right=x.left;
                if(x.left!=null){x.left.parent=y;}
                z.left=x.right;
                if(x.right!=null){x.right.parent=z;}
                x.left=y;
                y.parent=x;
                x.right=z;
                z.parent=x;
                if(y.left!=null && y.right!=null){
                    y.height=Math.max(y.left.height,y.right.height)+1;
                }
                else if(y.left!=null || y.right!=null){
                    y.height=1;
                }
                else{y.height=0; }
                if(z.left!=null && z.right!=null){
                    z.height=Math.max(z.left.height,z.right.height)+1;
                }
                else if(z.left!=null || z.right!=null){
                    z.height=1;
                }
                else{z.height=0;}
                x.height=Math.max(y.height,z.height)+1;
            }else if(z.right==y && y.left==x){//double rotation (right, left)
                if(z.parent!=null){
                	if(z.parent.right==z){ z.parent.right=x;}
					else if(z.parent.left==z){ z.parent.left=x;}
				}
                x.parent=z.parent;
                y.left=x.right;
                if(x.right!=null){x.right.parent=y;}
                z.right=x.left;
                if(x.left!=null){x.left.parent=z;}
                x.left=z;
                z.parent=x;
                x.right=y;
                y.parent=x;
                if(y.left!=null && y.right!=null){
                    y.height=Math.max(y.left.height,y.right.height)+1;
                }
                else if(y.left!=null || y.right!=null){
                    y.height=1;
                }
                else{y.height=0;}
                if(z.left!=null && z.right!=null){
                    z.height=Math.max(z.left.height,z.right.height)+1;
                }
                else if(z.left!=null || z.right!=null){
                    z.height=1;
                }
                else{z.height=0;}
                x.height=Math.max(y.height,z.height)+1;
            }
			while(temp.parent!=null){temp=temp.parent;}
			root=temp;
            return;
        }
    }
    boolean remove(int d){
    	tnode temp=root;

    	while(temp!=null){
    		if(d<temp.data){
    			if(temp.left!=null){temp=temp.left;}
    			else{return false;}
    		}else if(d>temp.data){
    			if(temp.right!=null){temp=temp.right;}
    			else{return false;}
    		}else{break;}
    	}
    	if(temp.data == d){
    		if(temp.left==null && temp.right==null){
    			if(temp.parent.right==temp){
    				temp.parent.right=null;
    				if(temp.parent.left!=null && temp.parent.left.height==0){
						size--;
                        return true;
                    }
    			}
    			else if(temp.parent.left==temp){
    				temp.parent.left=null;
    				if(temp.parent.right!=null && temp.parent.right.height==0){
                        size--;
                        return true;
                    }
    			}
    		}else if(temp.left==null && temp.right!=null){
    			if(temp.parent.left==temp){
    				temp.parent.left=temp.right;
    				temp.right.parent=temp.parent;
    				if(temp.parent.right.height==1){
    					size--;
    					return true;}
    			}else if(temp.parent.right==temp){
    				temp.parent.right=temp.right;
	    			temp.right.parent=temp.parent;
    				if(temp.parent.left.height==1){
						size--;
    					return true;
					}
    			}
    		}else if(temp.left!=null && temp.right==null){
    			if(temp.parent.left==temp){
    				temp.parent.left=temp.left;
	    			temp.left.parent=temp.parent;
    				if(temp.parent.right.height==1){
                        size--;
    					return true;
					}
    			}else if(temp.parent.right==temp){
    				temp.parent.right=temp.left;
    				temp.left.parent=temp.parent;
    				if(temp.parent.left.height==1){
                        size--;
    					return true;}
    			}
    		}else if(temp.left!=null && temp.right!=null){
    			tnode suc=temp.right;    //successor
    			while(suc.left!=null){
    				suc=suc.left;
    			}
    			//temp.Delete(suc);
    			temp.data=suc.data;
				if(suc.parent.left==suc){suc.parent.left = suc.right;}
				else{suc.parent.right = suc.right;}
				if(suc.right!=null){
					suc.right.parent  = suc.parent;
				}
				size--;
				temp = suc;
    		}
    	}
        tnode z=null;//unbalanced node
    	tnode y=null;//child of z having greater height
    	tnode x=null;//child of y having greater height
    	while(temp.parent!=null){
    		temp=temp.parent;
			if(temp.right==null || temp.left==null){
				if (temp.left==null && temp.right==null){
					temp.height=0;
				}else if(temp.right==null && temp.left.height ==0){
					temp.height=1;
				}else if(temp.left==null && temp.right.height==0){
					temp.height=1;
				}else if(temp.left==null && temp.right.height==1){
					z=temp;
					y=temp.right;
					if(y.right!=null){x=y.right;}
					else if(y.left!=null){x=y.left;}
					if(y.right==x){//left rotation
						y.parent=z.parent;
						if(z.parent!=null){
							if(z.parent.right==z){z.parent.right=y;}
							else{z.parent.left=y;}
						}
						z.right=y.left;
						if(y.left!=null){y.left.parent=z;}
						y.left=z;
						z.parent=y;
						if(z.right==null){z.height=0;}
						else{z.height=1;}
						y.height=Math.max(z.height,x.height)+1;
						temp=y;
					}
					else if(y.left==x){//double rotation (right,left)
						x.parent=z.parent;
						if(z.parent!=null){
							if(z.parent.right==z){z.parent.right=x;}
							else{z.parent.left=x;}
						}
						x.left=z;
						z.parent=x;
						x.right=y;
						y.parent=x;
						z.right=null;
						y.left=null;
						z.height=0;
						//y.height=0;
						if(y.right==null){y.height=0;}
						else{y.height=1;}
						x.height=Math.max(z.height,y.height)+1;
						temp=x;
					}
				}else if(temp.right==null && temp.left.height==1){
					z=temp;
					y=temp.left;
					if(y.left!=null){x=y.left;}
					else{x=y.right;}
					if(y.left==x){
						y.parent=z.parent;
						if(z.parent!=null){
							if(z.parent.right==z){z.parent.right=y;}
							else{z.parent.left=y;}
						}
						z.left=y.right;
						if(y.right!=null){y.right.parent=z;}
						y.right=z;
						z.parent=y;
						if(z.left==null){z.height=0;}
						else{z.height=1;}
						y.height=Math.max(z.height,x.height)+1;
						temp=y;
					}
					else if(y.right==x){
						x.parent=z.parent;
						if(z.parent!=null){
							if(z.parent.right==z){z.parent.right=x;}
							else{z.parent.left=x;}
						}
						x.right=z;
						z.parent=x;
						x.left=y;
						y.parent=x;
						z.left=null;
						y.right=null;
						z.height=0;
						y.height=0;
						x.height = 1;
						temp=x;
					}
				}
			}
    		else if(Math.abs(temp.left.height-temp.right.height)>1){
    			z=temp;
    			if(z.left.height>z.right.height){
    				y=temp.left;
    			}else{y=temp.right;}
    			if(y.left.height>=y.right.height){x=y.left;}
    			else{x=y.right;}
    			if(z.left==y && y.left==x){//right rotation
    				int ini = z.height;
    				y.parent=z.parent;
					if(z.parent!=null){
    					if(z.parent.right==z){z.parent.right=y;}
    					else{z.parent.left=y;}
					}
    				z.left=y.right;
    				if(y.right!=null){y.right.parent=z;}
    				z.parent=y;
    				y.right=z;
    				z.height=Math.max(z.left.height,z.right.height)+1;
    				y.height=Math.max(y.left.height,y.right.height)+1;
    				temp=y;
    				if (y.height==ini){ break;}
    			}else if(z.right==y && y.right==x){
    				int ini =z.height;
    				y.parent=z.parent;
					if(z.parent!=null){
    					if(z.parent.right==z){z.parent.right=y;}
    					else{z.parent.left=y;}
					}
    				z.right=y.left;
    				if(y.left!=null){y.left.parent=z;}
    				z.parent=y;
    				y.left=z;
    				z.height=Math.max(z.left.height,z.right.height)+1;
    				y.height=Math.max(y.left.height,y.right.height)+1;
    				temp=y;
    				if (y.height==ini){ break;}
    			}else if(z.left==y && y.right==x){//double rotation (right, left)
    				x.parent=z.parent;
					if(z.parent!=null){
    					if(z.parent.right==z){z.parent.right=x;}
    					else{z.parent.left=x;}
					}
    				y.right=x.left;
    				if(x.left!=null){x.left.parent=y;}
    				z.left=x.right;
    				if(x.right!=null){x.right.parent=z;}
    				x.left=y;
    				y.parent=x;
    				x.right=z;
    				z.parent=x;
    				if(z.left!=null && z.right!=null){
						z.height=Math.max(z.left.height,z.right.height)+1;
					}
    				else if(z.right!=null || z.left!=null){z.height=1;}
    				if(y.left!=null && y.right!=null){
						y.height=Math.max(y.left.height,y.right.height)+1;
					}
    				else if(y.left!=null || y.right!=null){y.height=1; }
    				else{y.height=0; }
    				x.height=Math.max(z.height,y.height)+1;
    				temp=x;
    			}else if(z.right==y && y.left==x){//double rotation (left, right)
    				x.parent=z.parent;
					if(z.parent!=null){
    					if(z.parent.right==z){z.parent.right=x;}
    					else{z.parent.left=x;}
					}
    				y.left=x.right;
    				if(x.right!=null){x.right.parent=y;}
    				z.right=x.left;
    				if(x.left!=null){x.left.parent=z;}
    				x.left=z;
    				z.parent=x;
    				x.right=y;
    				y.parent=x;
    				if(z.left!=null && z.right!=null){
						z.height=Math.max(z.left.height,z.right.height)+1;
					}
    				else if(z.right!=null || z.left!=null){z.height=1;}
    				if(y.left!=null && y.right!=null){
						y.height=Math.max(y.left.height,y.right.height)+1;
					}
    				else if(y.left!=null || y.right!=null){y.height=1; }
    				else{y.height=0;}
    				x.height=Math.max(z.height,y.height)+1;
    				temp=x;
    			}

    		}
    		else{
    			temp.height=Math.max(temp.left.height,temp.right.height)+1;
    		}

    	}
        return true;
    }
    int getSize(tnode t){
        if(t==null){return 0;}
		else{return (getSize(t.left) + getSize(t.right) + 1);}
    }
	void preorder(tnode t) {
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
}