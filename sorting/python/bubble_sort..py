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