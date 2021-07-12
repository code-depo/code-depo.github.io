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

class SLL:
	def __init__(self):
		self.head = None
		self.size = 0
	def insertFirst(self, D):
		n = node(self.head, D)
		self.head = n
		self.size +=1
	def removeFirst(self):
		if (self.size == 0):
			raise Exception("nothing to remove")
		else:
			self.head = self.head.getnext()
			self.size-=1
	def getNext(self, n):
		return n.next
	def get(self, i):
		if(i>=self.size or i<0):
			raise Exception("index out of bound")
		else:
			temp = self.head
			for i in range(i):
				temp=temp.next
			return temp.data
	def insert(self, posi, d):
		if(posi > self.size or posi <0):
			raise Exception("index out of bound")
		else:
			if(posi==0):
				self.insertFirst(d)
				return
			temp = self.head
			n = node(None, d)
			while(posi>1):
				temp = temp.next
				posi-=1
			n.next = temp.next
			temp.next = n
			self.size+=1
	def Del(self, posi):
		if(posi >= self.size or posi<0):
			raise Exception("index out of bound")
		else:
			if (posi==0):
				self.removeFirst()
				return
			temp = self.head
			temp_prev = None
			while (posi>0):
				temp_prev = temp
				temp = temp.next
				posi-=1
			temp_prev.next = temp.next
			temp.next = None
			self.size-=1
	def find(self, d):
		temp = self.head
		for i in range(self.size):
			if (temp.data == d):
				return i
			temp = temp.next
		return -1
	def remove(self, d):
		temp = self.head
		temp_prev = None
		for i in range(self.size):
			if(temp.data == d):
				break
			temp_prev = temp
			temp = temp.next
		if(temp == self.head):
			self.removeFirst()
			return True
		elif (temp!=None):
			temp_prev.next = temp.next
			self.size-=1
			return True
		else:
			return False

