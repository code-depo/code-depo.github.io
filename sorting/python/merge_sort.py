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