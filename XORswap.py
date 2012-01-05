#!/usr/bin/python

a = 6
b = 7
a = a+b
b = a-b
a = a-b
print a, b

a^=b
print a,b
b^=a
print a,b
a^=b
print a,b
