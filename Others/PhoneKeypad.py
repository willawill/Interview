

def word_numbers(input):
  digit_map = {
    '0' : '0',
    '1' : '1',
    '2': 'abc',
    '3': 'def',
    '4': 'ghi',
    '5': 'jkl',
    '6': 'mno',
    '7': 'pqrs',
    '8': 'tuv',
    '9': 'wxyz',
}
  input = str(input)
  ret = ['']
  for char in input:
   letters = digit_map.get(char,'')
   ret = [prefix+letter for prefix in ret for letter in letters]
  return ret

input = "2125420421"
result = []
result = word_numbers(input)
print result