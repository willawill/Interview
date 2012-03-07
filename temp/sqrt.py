def sqrt(n):
	low = 0
	high = n + 1
	while high -low >1:
		mid = float(low) + float(high-low)/2f
		if mid * mid <= n:
			low = mid
		else:
			high = mid
	return low
## {{{ http://code.activestate.com/recipes/577821/ (r1)
def isqrt(x):
    if x < 0:
        raise ValueError('square root not defined for negative numbers')
    n = int(x)
    if n == 0:
        return 0
    a, b = divmod(n.bit_length(), 2)
    x = 2**(a+b)
    while True:
        y = (x + n//x)//2
        if y >= x:
            return x
        x = y
## end of http://code.activestate.com/recipes/577821/ }}}

print sqrt(20)