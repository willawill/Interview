#!/usr/bin/python
import math
a=[2,3,4,5,6,7]
b=[2,4,6]
c=[2,2,3,4,5,6,7]

#Test if an array is an sequence.


class isSequence:
	def __init__(self , a):
		self.array = a
		self.mini = self.array[0]
		self.maxx = 0
	def findBoundary(self):
		for i in self.array:
			print i
			if (i < self.mini):
				self.mini = i
				print self.mini
			if (i > self.maxx):
				self.maxx = i
			
		print self.mini
	def isSequence(self):
		self.findBoundary()
		print self.mini
		if (self.maxx - self.mini+1)<len(self.array):
			return False
		for i in range(len(self.array)):
			self.array[i] -=self.mini
		self.printout()
		for i in range(len(self.array)):
			temp = abs(self.array[i])
			if (self.array[temp] >0):
				self.array[temp]*= -1 
		for i in range(self.maxx-self.mini):
			if self.array[i] > 0:
				return False
		return True
	def printout(self):
		for i in self.array:
			print i,
test1 = isSequence(a)
test2 = isSequence(b)
test3 = isSequence(c)

print test1.isSequence()
print test2.isSequence()
		
