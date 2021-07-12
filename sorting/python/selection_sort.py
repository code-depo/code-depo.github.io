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