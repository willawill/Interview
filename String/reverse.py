	def reverseString(s):
	if (s == ""):
		return s
	else:	
		return reverseString(s[1:])+s[0]


print reverseString("abcd")
t = "abcd"
backward = lambda t: t[-1] + backward(t[:-1]) if t else t 
print backward(t)
