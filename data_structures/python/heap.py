class Heap:
    def __init__(s):
        s.heap = []
    def Add(s,d):
        s.heap.append(d)
        ptr = len(s.heap) -1
        while(ptr >=0 and s.heap[(ptr-1)//2] > s.heap[ptr]):
            (s.heap[ptr], s.heap[(ptr-1)//2]) = (s.heap[(ptr-1)//2], s.heap[ptr])
            ptr = (ptr-1)//2
        return
    def Find(s,d):#linear search of by level order
        n = len(s.heap)
        for i in range(n):
            if(s.heap[i] == d):
                return i
        return -1
    def Heapify(s, ptr):
#swaps the large element at ptr with smaller child untill heap is formed
        n = len(s.heap)
        while(2*ptr+2 < n):
            if (s.heap[2*ptr+2] < s.heap[ptr] and s.heap[2*ptr+2] < s.heap[2*ptr+1]):
                (s.heap[ptr], s.heap[2*ptr+2]) = (s.heap[2*ptr+2], s.heap[ptr])
                ptr = 2*ptr + 2
            elif(s.heap[2*ptr+1] < s.heap[ptr]):
                (s.heap[ptr], s.heap[2*ptr+1]) = (s.heap[2*ptr+1], s.heap[ptr])
                ptr = 2*ptr + 1
            else:
                break
        if (2*ptr+1 < n and s.heap[2*ptr+1]<s.heap[ptr]):
            (s.heap[ptr], s.heap[2*ptr+1]) = (s.heap[2*ptr+1], s.heap[ptr])
        return
    def remove(s,d):
        ptr = s.Find(d)
        if(ptr !=-1):
            last = len(s.heap)-1
            s.heap[ptr] = s.heap[last]
            del s.heap[last]
            s.Heapify(ptr)
            return True
        return False
    def makeHeap(s, l):
        s.heap = l
        n = len(l)
        done = n-1
        while(done>=0):
            s.Heapify(done)
            done-=1
        #making heaps bottom up:
        #each of the left, right subtree will be heap at
        #pointer 'done'. The violation at 'done' is rectified
        #by Heapify(done). Thus, making the subtree rooted
        #at 'done' heap. move 'done' left then upwards.
    def size(s):
        return len(s.heap)