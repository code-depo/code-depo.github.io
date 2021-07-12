from random import randint  #required for random number

def quick_sort(List):
	n = len(List)
	if(n<2):                   #base case 0 or 1 element
		return List
	else:
		mid = randint(0,n-1)    #picking a random pivot
		head = 0
		tail = n-1
		p = List[mid]
		while (head<tail):		#partition
			while ((List[head] < p or head == mid) and head<tail):   #searching for an element in LHS >= pivot
				head += 1
			while ((List[tail] > p or tail==mid) and head<tail ):    #searching for an element in RHS <= pivot
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
		(List[head], List[mid]) = (List[mid],List[head])        #putting the pivot in it's correct position
		if(head == n-1):                                        #recursive call
			return quick_sort(List[:head]) + [p]
		else:
			return quick_sort(List[:head]) + [p] + quick_sort(List[head+1:])
