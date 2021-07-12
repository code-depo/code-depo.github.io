def selection_sort(List):
	n = len(List)
	for pointer in range(n):
		Min = pointer
		for i in range(pointer, n):	#find the index of smallest element
			if(List[i] < List[Min]):
				Min = i
		temp = List[pointer]	#swap
		List[pointer] = List[Min]
		List[Min] = temp
	return List

def bubble_sort(List):
	n = len(List)
	for i in range(n):
		j=0
		for j in range(1,n - i):
			if (List[j] < List[j-1]):
				temp = List[j-1]
				List[j-1] = List[j]
				List[j] = temp
	return List

def insertion_sort(List):
	n = len(List)
	for i in range(1,n):
		temp = List[i]
		j = i-1
		while (j>=0 and (List[j] > temp)):
			List[j+1] = List[j]
			j-=1
		List[j+1]=temp
	return List

def merge(List1, List2):
	n1 = len(List1)
	n2 = len(List2)
	p1 = 0
	p2 = 0
	Merged_list=[]
	while (p1 < n1 and p2 < n2):
		if (List1[p1] <List2[p2]):
			Merged_list.append(List1[p1])
			p1 += 1
		else:
			Merged_list.append(List2[p2])
			p2+=1
	if(p1<n1):
		Merged_list = Merged_list + List1[p1:]
	elif(p2<n2):
		Merged_list = Merged_list + List2[p2:]
	return Merged_list

def merge_sort(List):
	n = len(List)
	if( n <= 1 ):
		return List
	return merge( merge_sort(List[:n//2]), merge_sort(List[n//2:]) )

from random import randint

def quick_sort(List):
	n = len(List)
	if(n<2):
		return List
	else:
		mid = randint(0,n-1)
		head = 0
		tail = n-1
		p = List[mid]
		while (head<tail):		#partition
			while ((List[head] < p or head == mid) and head<tail):
				head += 1
			while ((List[tail] > p or tail==mid) and head<tail ):
				tail -=1
			if(head == tail):
				break
			(List[head],List[tail]) = (List[tail], List[head])	#swap
			if(tail-head > 1):
				tail-=1
				head+=1
			elif(head<mid):
				head+=1
			elif(head>mid):
				tail-=1
		if(mid<head and List[head] >= p):
			head-=1
		elif(mid>head and List[head] <= p):
			head+=1
		(List[head], List[mid]) = (List[mid],List[head])
		if(head == n-1):
			return quick_sort(List[:head]) + [p]
		else:
			return quick_sort(List[:head]) + [p] + quick_sort(List[head+1:])

def Heapify(l):
	n = len(l)
	done = n-1
	while(done >= 0):
		ptr = done
		while (2*ptr + 2 < n):
			if(l[2*ptr+2] < l[ptr] and l[2*ptr+2] < l[2*ptr+1]):
				(l[ptr], l[2*ptr+2]) = (l[2*ptr+2], l[ptr])
				ptr = 2*ptr+2
			elif (l[2*ptr+1] < l[ptr]):
				(l[ptr], l[2*ptr+1]) = (l[2*ptr+1], l[ptr])
				ptr = 2*ptr+1
			else:
				break
		if(2*ptr+1 < n and l[2*ptr+1] < l[ptr]):
			(l[ptr], l[2*ptr+1]) = (l[2*ptr+1], l[ptr])
		done -= 1
	return l

def heap_sort(List):
	n = len(List)
	List = Heapify(List)
	end = n - 1
	while(end>0):
		(List[0], List[end]) = (List[end], List[0])
		ptr = 0
		while(2*ptr+2<end):
			if(List[2*ptr+2]<List[2*ptr+1] and List[2*ptr+2] < List[ptr]):
				(List[ptr], List[2*ptr+2]) = (List[2*ptr+2], List[ptr])
				ptr = 2*ptr + 2
			elif(List[2*ptr+1] < List[ptr]):
				(List[ptr], List[2*ptr+1]) = (List[2*ptr+1], List[ptr])
				ptr = 2*ptr + 1
			else:
				break
		if(2*ptr+1<end and List[2*ptr+1] < List[ptr]):
			(List[ptr], List[2*ptr+1]) = (List[2*ptr+1], List[ptr])
		end -= 1
	return List

def bitstr2int(s):
	n=0
	size = len(s)
	posi = -1
	while(abs(posi)<=size):
		n += int(s[posi])*(2**abs(posi+1))
		posi -= 1
	return n

def int2bitstr(n):
	s=""
	while(n>0):
		s = str(n%2) + s
		n = n//2
	return s

def radix_sort(List):
	strlist = []
	n=len(List)
	Max = 0
	for i in List:
		s = int2bitstr(i)
		if(len(s) > Max):
			Max = len(s)
		strlist.append(s)
	for i in range(n):
		strlist[i] = '0'*(Max-len(strlist[i])) + strlist[i]
	ptr = -1
	while(ptr >= -Max):
		zero = []
		ones = []
		for i in strlist:
			if(i[ptr] == '0'):
				zero.append(i)
			else:
				ones.append(i)
		strlist = zero + ones
		ptr -= 1
	for i in range(n):
		List[i] = bitstr2int(strlist[i])
	return List
