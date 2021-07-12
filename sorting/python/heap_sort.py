def Heapify(l):           #making a heap list of any list 
	n = len(l)
	done = n-1            #start from bottom right-most child
	while(done >= 0):
		ptr = done
		while (2*ptr + 2 < n):                                  #move the int to the bottom untill
			if(l[2*ptr+2] < l[ptr] and l[2*ptr+2] < l[2*ptr+1]):#both its children are >= to itself
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
	List = Heapify(List)    #make heap of the list
	end = n - 1
	while(end>0):
		(List[0], List[end]) = (List[end], List[0])         #swap the bottom right-most element with the root(smallest)
		ptr = 0
		while(2*ptr+2<end):   #heapify ignoring the sorted end of list by moving the swapped element to the right position
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
	return List       #finally we get a reverse sorted list which can be reversed if required.