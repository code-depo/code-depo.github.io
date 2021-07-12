class node:
	def __init__(self, Node, data):
		self.next = Node
		self.data = data
	def setnext(self, n):
		self.next = n
	def getele(self):
		return self.data
	def setele(self, data):
		self.data = data
	def getnext(self):
		return self.next

class stack:
    def __init__(s):#s denotes self
        s.top = node(None,None)#sentinal node, can be made without sentinal
        s.size = 0
    def push(s, d):
        n = node(s.top, d)
        s.top = n
        s.size += 1
    def pop(s):#removes top and returns data of it
        if(s.size == 0):
            raise Exception("Stack empty")
        else:
            d = s.top.data
            s.top = s.top.next
            s.size -=1
            return d
    def top(s):
        if(s.size == 0):
            raise Exception("Stack empty")
        else:
            return s.top.data
    def getnext(s):
        return s.top.next
