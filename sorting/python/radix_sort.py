# note this is only for +ve integer
# can be extended to signed by comparing the first bit
# and applying to the -ve, +ve numbers seperately
def bitstr2int(s):      #function to convert unsigned bitstring to integer
	n=0
	size = len(s)
	posi = -1
	while(abs(posi)<=size):
		n += int(s[posi])*(2**abs(posi+1))
		posi -= 1
	return n

def int2bitstr(n):      #function to convert +ve int to unsigned bitstring
	s=""
	while(n>0):
		s = str(n%2) + s
		n = n//2
	return s

def radix_sort(List):
	strlist = []
	n=len(List)
	Max = 0
	for i in List:          #converting the int list to bitstr list
		s = int2bitstr(i)
		if(len(s) > Max):
			Max = len(s)
		strlist.append(s)
	for i in range(n):
		strlist[i] = '0'*(Max-len(strlist[i])) + strlist[i]        #making all bitstr to the same length
	ptr = -1
	while(ptr >= -Max):             #starting from right most bit doing stable partition of bitstr list
		zero = []
		ones = []
		for i in strlist:
			if(i[ptr] == '0'):
				zero.append(i)
			else:
				ones.append(i)
		strlist = zero + ones
		ptr -= 1
	for i in range(n):              #converting the bit str to int
		List[i] = bitstr2int(strlist[i])
	return List
