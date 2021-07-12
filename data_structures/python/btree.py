class tnode:
    def __init__(s,d,l,r,p):
        s.data = d
        s.left = l
        s.right = r
        s.parent = p
        s.size = 1

class btree:
    def __init__(s, d):
        s.root = tnode(d, None, None, None)
    def Add(s, d):
        temp = s.root
        while(True):
            temp.size+=1
            if(d<temp.data and temp.left!=None):
                temp = temp.left
            elif(d<temp.data and temp.left == None):
                t = tnode(d,None,None,temp)
                temp.left = t
                break
            elif(d>=temp.data and temp.right !=None):
                temp = temp.right
            elif(d>=temp.data and temp.right == None):
                t = tnode(d,None,None,temp)
                temp.right = t
                break
        return
    def remove(s,d):
        temp = s.root
        while(True):
            if(d==temp.data):
                break
            elif(temp.left!=None and d<temp.data):
                temp = temp.left
            elif(d>=temp.data and temp.right!=None):
                temp = temp.right
            elif(temp.left==None and temp.right==None):
                return False
        if(temp.data == d):
            if(temp.right == None and temp.left==None):
                if(temp.parent.left == temp):
                    temp.parent.left = None
                else:
                    temp.parent.right = None
            elif(temp.left!=None and temp.right==None):
                if(temp!=s.root and temp.parent.left == temp):
                    temp.parent.left = temp.left
                elif(temp!=s.root and temp.parent.right==temp):
                    temp.parent.right = temp.left
                temp.left.parent = temp.parent
                temp = None
            elif(temp.right!=None and temp.left==None):
                if(temp!=s.root and temp.parent.left==temp):
                    temp.parent.left = temp.right
                elif(temp!=s.root and temp.parent.right == temp):
                    temp.parent.right = temp.right
                temp.right.parent = temp.parent
                temp = None
            else:
                t2 = temp.right
                while(t2.left!=None):
                    t2 = t2.left
                temp.data = t2.data
                if(t2.right!=None):
                    if(t2.parent.left==t2):
                        t2.parent.left=t2.right
                    if(t2.parent.right==t2):
                        t2.parent.right=t2.right
                    t2.right.parent = t2.parent
                else:
                    if(t2.parent.left == t2):
                        t2.parent.left=None
                    else:
                        t2.parent.right = None
                    while(t2.parent!=None):
                        t2 = t2.parent
                        t2.size -=1
                    t2=None
                    temp = None
                    return True
            while(temp.parent!=None):
                temp = temp.parent
                temp.size-=1
            temp = None
            return True
        return False
    def Find(s,d):
        temp = s.root
        while(temp.data!=d):
            if(temp.data>d):
                if(temp.left !=None):
                    temp = temp.left
                else:
                    return None
            else:
                if(temp.right!=None):
                    temp = temp.right
                else:
                    return None
        return temp
    def preorder(s,t):#note root must be passed as argument eg - preorder(tree.root)
        if(t==None):
            return
        else:
            print(t.data, end=',')
            s.preorder(t.left)
            s.preorder(t.right)
    def postorder(s,t):
        if(t==None):
            return
        else:
            s.postorder(t.left)
            s.postorder(t.right)
            print(t.data, end=',')
    def inorder(s,t):
        if(t==None):
            return
        else:
            s.inorder(t.left)
            print(t.data, end=',')
            s.inorder(t.right)
    def levelorder(s,t):
        v = []
        v.append(t)
        w = []
        while(len(v) !=0):
            temp  = v[0]
            if(temp.left!=None):
                v.append(temp.left)
            if(temp.right!=None):
                v.append(temp.right)
            w.append(temp.data)
            del v[0]
        n = len(w)
        for i in range(n):
            print(w[i],end=',')
    def size(s):
        return s.root.size
        