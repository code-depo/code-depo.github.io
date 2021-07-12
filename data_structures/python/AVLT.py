class tnode:
    def __init__(s, d,l, r, p):
        s.data = d
        s.left = l
        s.right = r
        s.parent = p
        s.height = 0

class AVLT:
    def __init__(s, d):
        s.root = tnode(d, None,None,None)
        s.size = 1
    def insert(s, d):
        t = tnode(d, None,None,None)
        temp = s.root
        s.size+=1
        while(temp!=None):
            if(d < temp.data):
                if(temp.left!=None):
                    temp = temp.left
                elif(temp.left == None):
                    temp.left = t
                    t.parent = temp
                    if(temp.right == None):
                        temp.height = 1
                    elif (temp.height == 1):
                        return
                    break
            else:
                if(temp.right != None):
                    temp = temp.right
                elif(temp.right == None):
                    temp.right = t
                    t.parent = temp
                    if(temp.left == None):
                        temp.height = 1
                    elif(temp.height == 1):
                        return#already balanced
                    break
        y=z=x= None
        while(temp!=None):
            if(temp.right==None and temp.left.height==1):
                z = temp
                y = temp.left
                if(y.left!=None):
                    x = y.left
                else:
                    x = y.right
                break
            elif(temp.left==None and temp.right.height==1):
                z = temp
                y = temp.right
                if(y.right!=None):
                    x=y.right
                else:
                    x=y.left
                break
            elif(temp.left!=None and temp.right!=None and abs(temp.left.height-temp.right.height)>1):
                z=temp
                if(z.left.height > z.right.height):
                    y=z.left
                else:
                    y=z.right
                if(y.left.height > y.right.height):
                    x=y.left
                else:
                    x=y.right
                break
            if(temp.right!=None and temp.left!=None):
                temp.height = max(temp.left.height, temp.right.height)+1
            elif(temp.left==None or temp.right==None):
                temp.height = 1
            temp = temp.parent
        if(x!=None and y!=None and z!=None):
            if(z.left==y and y.left==x):#right rotation
                if(z.parent!=None):
                    if(z.parent.right==z):
                        z.parent.right=y
                    else:
                        z.parent.left=y
                y.parent=z.parent
                z.left=y.right
                if(y.right!=None):
                    y.right.parent=z
                z.parent=y
                y.right=z
                if(z.left!=None and z.right!=None):
                    z.height = max(z.left.height,z.right.height)+1
                elif(z.right!=None or z.left!=None):
                    z.height=1
                else:
                    z.height=0
                y.height = max(z.height,x.height)+1
            elif(z.right==y and y.right==x):#left rotation
                if(z.parent!=None):
                    if(z.parent.right==z):
                        z.parent.right=y
                    else:
                        z.parent.left=y
                y.parent=z.parent
                z.right=y.left
                if(y.left!=None):
                    y.left.parent=z
                z.parent=y
                y.left=z
                if(z.left!=None and z.right!=None):
                    z.height=max(z.left.height,z.right.height)+1
                elif(z.left!=None or z.right!=None):
                    z.height=1
                else:z.height=0
                y.height = max(z.height,x.height)+1
            elif(z.left==y and y.right==x):#double rotation (left, right)
                if(z.parent!=None):
                    if(z.parent.right==z):
                        z.parent.right=x
                    elif(z.parent.left==z):
                        z.parent.left=x
                x.parent=z.parent
                y.right=x.left
                if(x.left!=None):
                    x.left.parent=y
                z.left=x.right
                if(x.right!=None):
                    x.right.parent=z
                x.left=y
                y.parent=x
                x.right=z
                z.parent=x
                if(y.left!=None and y.right!=None):
                    y.height=max(y.left.height,y.right.height)+1
                elif(y.left!=None or y.right!=None):
                    y.height=1
                else:
                    y.height=0
                if(z.left!=None and z.right!=None):
                    z.height=max(z.left.height,z.right.height)+1
                elif(z.left!=None or z.right!=None):
                    z.height=1
                else:
                    z.height=0
                x.height=max(y.height,z.height)+1
            elif(z.right==y and y.left==x):#double rotation (right, left)
                if(z.parent!=None):
                    if(z.parent.right==z):
                        z.parent.right=x
                    elif(z.parent.left==z):
                        z.parent.left=x
                x.parent=z.parent
                y.left=x.right
                if(x.right!=None):
                    x.right.parent=y
                z.right=x.left
                if(x.left!=None):
                    x.left.parent=z
                x.left=z
                z.parent=x
                x.right=y
                y.parent=x
                if(y.left!=None and y.right!=None):
                    y.height=max(y.left.height,y.right.height)+1
                elif(y.left!=None or y.right!=None):
                    y.height=1
                else:
                    y.height=0
                if(z.left!=None and z.right!=None):
                    z.height=max(z.left.height,z.right.height)+1
                elif(z.left!=None or z.right!=None):
                    z.height=1
                else:
                    z.height=0
                x.height=max(y.height,z.height)+1
            while(temp.parent!=None):
                temp = temp.parent
            s.root = temp
            return
    def getSize(s, t):
        if(t==None):
            return 0
        else:
            return  (s.getSize(t.left) + s.getSize(t.right) + 1)
    def preorder(s,t):
        if(t==None):
            return
        else:
            print(t.data, end=",")
            s.preorder(t.left)
            s.preorder(t.right)
    def postorder(s,t):
        if (t==None):
            return
        else:
            s.postorder(t.left)
            s.postorder(t.right)
            print(t.data,end=",")
    def inorder(s,t):
        if(t==None):
            return
        else:
            s.inorder(t.left)
            print(t.data,end=',')
            s.inorder(t.right)

    def remove(s, d):
        temp = s.root
        while(temp != None):
            if(d < temp.data):
                if(temp.left != None):
                    temp = temp.left
                else:
                    return False
            elif(d > temp.data):
                if(temp.right != None):
                    temp = temp.right
                else:
                    return False
            else:
                break
        if(temp.data == d):
            if(temp.left == None and temp.right == None):
                if(temp.parent.right == temp):
                    temp.parent.right = None
                    if(temp.parent.left != None and temp.parent.left.height == 0):
                        s.size -= 1
                        return True
                    elif(temp.parent.left == temp):
                        temp.parent.left = None
                        if(temp.parent.right != None and temp.parent.right.height == 0):
                            s.size -= 1
                            return True
            elif(temp.left == None and temp.right != None):
                if(temp.parent.left == temp):
                    temp.parent.left = temp.right
                    temp.right.parent = temp.parent
                    if(temp.parent.right.height == 1):
                        s.size -= 1
                        return True
                elif(temp.parent.right == temp):
                    temp.parent.right = temp.right
                    temp.right.parent = temp.parent
                    if(temp.parent.left.height == 1):
                        s.size -= 1
                        return True
            elif(temp.left != None and temp.right == None):
                if(temp.parent.left == temp):
                    temp.parent.left = temp.left
                    temp.left.parent = temp.parent
                    if(temp.parent.right.height == 1):
                        s.size -= 1
                        return True
                elif(temp.parent.right == temp):
                    temp.parent.right = temp.left
                    temp.left.parent = temp.parent
                    if(temp.parent.left.height == 1):
                        s.size -= 1
                        return True
            elif(temp.left != None and temp.right != None):
                suc = temp.right  # successor
                while(suc.left != None):
                    suc = suc.left
		#temp.Delete(suc)
                temp.data = suc.data
                if(suc.parent.left == suc):
                    suc.parent.left = suc.right
                else:
                    suc.parent.right = suc.right
                if(suc.right!=None):
                    suc.right.parent = suc.parent
                s.size-=1
                temp = suc
        #temp is the node which is deleted above which we need to check for height
        z=y=x=None
        while(temp.parent!=None):
            temp=temp.parent
            if(temp.left == None or temp.right == None):
                if (temp.left==None and temp.right==None):
                    temp.height=0
                elif (temp.right == None and temp.left.height==0):
                    temp.height=1
                elif(temp.left == None and temp.right.height==0):
                    temp.height=1
                elif(temp.left==None and temp.right.height==1):
                    z=temp
                    y=temp.right
                    if(y.right!=None):
                        x=y.right
                    elif(y.left!=None):
                        x=y.left
                    if(y.right==x):#left rotation
                        y.parent=z.parent
                        if(z.parent!=None):
                            if(z.parent.right==z):
                                z.parent.right=y
                            else:
                                z.parent.left=y
                        z.right=y.left
                        if(y.left!=None):
                            y.left.parent=z
                        y.left=z
                        z.parent=y
                        if(z.right==None):
                            z.height=0
                        else:
                            z.height=1
                        y.height= max(z.height,x.height)+1
                        temp=y
                    elif(y.left==x):#double rotation (right,left)
                        x.parent=z.parent
                        if(z.parent!=None):
                            if(z.parent.right==z):
                                z.parent.right=x
                            else:
                                z.parent.left=x
                        x.left=z
                        z.parent=x
                        x.right=y
                        y.parent=x
                        z.right=None
                        y.left=None
                        z.height=0
                        #y.height=0
                        if(y.right==None): y.height=0
                        else: y.height=1
                        x.height = max(z.height,y.height)+1
                        temp=x
                elif(temp.right==None and temp.left.height==1):
                    z=temp
                    y=temp.left
                    if(y.left!=None):
                        x=y.left
                    else:
                        x=y.right
                    if(y.left==x):
                        y.parent=z.parent
                        if(z.parent!=None):
                            if(z.parent.right==z):
                                z.parent.right=y
                            else:
                                z.parent.left=y
                        z.left=y.right
                        if(y.right!=None):y.right.parent=z
                        y.right=z
                        z.parent=y
                        if(z.left==None):z.height=0
                        else:z.height=1
                        y.height= max(z.height,x.height)+1
                        temp=y
                    elif(y.right==x):
                        x.parent=z.parent
                        if(z.parent!=None):
                            if(z.parent.right==z):
                                z.parent.right=x
                            else:
                                z.parent.left=x					
                        x.right=z
                        z.parent=x
                        x.left=y
                        y.parent=x
                        z.left=None
                        y.right=None
                        z.height=0
                        y.height=0
                        x.height = 1
                        temp=x
            elif( abs(temp.left.height-temp.right.height)>1):
                z=temp
                if(z.left.height>z.right.height):
                    y=temp.left
                else:
                    y=temp.right
                if(y.left.height>=y.right.height):
                    x=y.left
                else:
                    x=y.right
                if(z.left==y and y.left==x):#right rotation
                    ini = z.height
                    y.parent=z.parent
                    if(z.parent!=None):
                        if(z.parent.right==z):
                            z.parent.right=y
                        else:
                            z.parent.left=y
                    z.left = y.right
                    if(y.right != None):
                        y.right.parent = z
                    z.parent = y
                    y.right = z
                    z.height = max(z.left.height,z.right.height)+1
                    y.height = max(y.left.height,y.right.height)+1
                    temp=y
                    if (y.height==ini): break
                elif(z.right==y and y.right==x):
                    ini =z.height
                    y.parent=z.parent
                    if(z.parent!=None):
                        if(z.parent.right==z):z.parent.right=y
                        else:z.parent.left=y
                    z.right = y.left
                    if(y.left!=None): y.left.parent=z
                    z.parent = y
                    y.left = z
                    z.height = max(z.left.height,z.right.height)+1
                    y.height = max(y.left.height,y.right.height)+1
                    temp = y
                    if (y.height == ini): break
                elif(z.left==y and y.right==x):#double rotation (right, left)
                    x.parent=z.parent
                    if(z.parent!=None):
                        if(z.parent.right==z):z.parent.right=x
                        else:z.parent.left=x
                    y.right=x.left
                    if(x.left!=None):x.left.parent=y
                    z.left=x.right
                    if(x.right!=None):x.right.parent=z
                    x.left=y
                    y.parent=x
                    x.right=z
                    z.parent=x
                    if(z.left!=None and z.right!=None):
                        z.height= max(z.left.height,z.right.height)+1
                    elif(z.right!=None or z.left!=None):
                        z.height=1
                    if(y.left!=None and y.right!=None):
                        y.height= max(y.left.height,y.right.height)+1
                    elif(y.left!=None or y.right!=None):y.height=1 
                    else:y.height=0 
                    x.height= max(z.height,y.height)+1
                    temp=x
                elif(z.right==y and y.left==x):#double rotation (left, right)
                    x.parent=z.parent
                    if(z.parent!=None):
                        if(z.parent.right==z):z.parent.right=x
                        else:z.parent.left=x
                    y.left=x.right
                    if(x.right!=None):x.right.parent=y
                    z.right=x.left
                    if(x.left!=None):x.left.parent=z
                    x.left=z
                    z.parent=x
                    x.right=y
                    y.parent=x
                    if(z.left!=None and z.right!=None):
                        z.height= max(z.left.height,z.right.height)+1
                    elif(z.right!=None or z.left!=None):
                        z.height=1
                    if(y.left!=None and y.right!=None):
                        y.height= max(y.left.height,y.right.height)+1
                    elif(y.left!=None or y.right!=None):y.height=1 
                    else:y.height=0
                    x.height= max(z.height,y.height)+1
                    temp=x
            else:
                temp.height= max(temp.left.height,temp.right.height)+1
        return True

t = AVLT(1)
for i in range(-2,2):
    t.insert(i)
t.preorder(t.root)
print('\n')
t.postorder(t.root)
t.remove(1)
print('\n')
t.preorder(t.root)
print('\n')
t.postorder(t.root)
print('\n')
print(t.root.height)