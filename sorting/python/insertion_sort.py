def insertion_sort(List):
	n = len(List)
	for i in range(1,n):
		temp = List[i]                      #ith element
		j = i-1
		while (j>=0 and (List[j] > temp)):  #shifting all the larger ints to right untill 
			List[j+1] = List[j]				# the correct place of the ith int
			j-=1
		List[j+1]=temp
	return List