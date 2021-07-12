class node:
    def __init__(s, n, p, d):
        s.next = n
        s.prev = p
        s.data = d

class queue:
    def __init__(s):
        s.last = None
        s.first = None
        s.size = 0
    def enqueue(s, d):
        n = node(s.last, None, d)
        if (s.last!=None):
            s.last.prev = n
        s.last = n
        if ( s.size == 0):
            s.first = n
        s.size+=1
    def dequeue(s):
        if (s.size == 0):
            raise Exception("queue empty")
        temp = s.first
        s.first = s.first.prev
        if(s.first != None):
            s.first.next = None
        s.size-=1
        return temp
    def getlast(s):
        if (s.size==0):
            raise Exception("queue empty")
        return s.last.data
    def getfirst(s):
        if(s.size == 0):
            raise Exception("queue empty")
        return s.first.data
    def traverse(s):
        temp = s.first
        for i in range(s.size):
            print(temp.data, end=',')
            temp = temp.prev