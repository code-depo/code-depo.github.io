class node:
    def __init__(s, n, p, d):
        s.next = n
        s.prev = p
        s.data = d
class DLL:
    def __init__(s):
        s.first = None
        s.last = None
        s.size = 0
    def insertFirst(s, d):
        n = node(s.first, None, d)
        if(s.first != None):
            s.first.prev = n
        s.first = n
        if (s.size==0):
            s.last = n
        s.size += 1
    def insertLast(s, d):
        n = node(None,s.last,d)
        if(s.last != None):
            s.last.next = n
        s.last = n
        if(s.size == 0):
            s.first = n
        s.size += 1
    def removeFirst(s):
        if(s.size==0):
            raise Exception("DLL empty, nothing to remove")
        else:
            s.first = s.first.next
            if(s.first != None):
                s.first.prev = None
            s.size -= 1
    def removeLast(s):
        if(s.size==0):
            raise Exception("DLL empty, nothing to remove")
        else:
            s.last = s.last.prev
            if (s.last != None):
                s.last.next = None
            s.size -= 1
    def get(s, i):
        if(i>= s.size or i<0):
            raise Exception("Index of bound for get")
        elif (i<s.size//2):
            temp = s.first
            for j in range(i):
                temp=temp.next
            return temp.data
        else:
            temp = s.last
            j = s.size-1
            while (j!=i):
                temp = temp.prev
                j-=1
            return temp.data
    def insert(s, posi, d):
        if(posi>s.size or posi<0):
            raise Exception("index out of bound for insert")
        else:
            n = node(None, None, d)
            if(posi <= s.size//2):
                if(posi == 0):
                    s.insertFirst(d)
                    return
                temp = s.first
                while (posi>1):
                    temp = temp.next
                    posi -=1
            else:
                if(posi == s.size):
                    s.insertLast()
                    return
                temp = s.last
                while(posi<s.size):
                    temp = temp.prev
                    posi+=1
            n.next = temp.next
            temp.next.prev = n
            temp.next = n
            n.prev = temp
            s.size +=1
    def remove(s,d):
        temp = s.first
        for i in range(s.size):
            if(temp.data == d):
                break
            temp = temp.next
        if (temp == s.first):
            s.removeFirst()
            return True
        elif (temp == s.last):
            s.removeLast
            return True
        elif (temp != None):
            temp.prev.next = temp.next
            temp.next.prev = temp.prev
            temp = None
            s.size -=1
            return True
        else:
            return False
    def Del (s, posi):
        if(posi>s.size or posi<0):
            raise Exception("index out of bound for del")
        if (posi == 0):
            s.removeFirst()
            return
        elif (posi == s.size - 1):
            s.removeLast
            return
        else:
            temp = s.first
            while(posi>0):
                temp = temp.next
                posi-=1
            temp.prev.next = temp.next
            temp.next.prev = temp.prev
            temp = None
            s.size -=1
    def Find(s,d):
        temp = s.first
        for i in range(s.size):
            if(temp.data == d):
                return i
            temp = temp.next
        return -1
    def traverse(s):
        temp = s.first
        for i in range(s.size):
            print(temp.data, end = ',')
            temp = temp.next
        print()
