def qsort1(list):
    """
    Quicksort using list comprehensions
    >>> qsort1<<docstring test numeric input>>
    <<docstring test numeric output>>
    >>> qsort1<<docstring test string input>>
    <<docstring test string output>>
    """
    if not list: 
        return []
    else:
        pivot = list[0]
        lesser = qsort1([x for x in list[1:] if x < pivot])
        greater = qsort1([x for x in list[1:] if x >= pivot])
        return lesser + [pivot] + greater

s=[98,56,23,15,69]
s2 = []
s2 = qsort1(s)
print s2