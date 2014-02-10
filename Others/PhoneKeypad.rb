#!/usr/bin/ruby

def digit_map
 ['0', '1', 'abc', 'def', 'ghi', 'jkl', 'mno','pqrs','tuv','wxyz']
end

def word_numbers(phone_number)
  results = [""]
  letters = phone_number.split('')
  letters.each do |letter| # 2
    words = digit_map[letter.to_i] #abc
    results = results.inject([]) do |r, pre|
      r +=  words.split('').collect {|word| pre + word }
    end
  end
  results
end

p word_numbers("212")

# for prefix, each one add a new letter.
#   [] - > ["a", "b", "c"] -> ["a1", "b1", "c1"] -> ["a1a", "a1b", "a1c"...]
