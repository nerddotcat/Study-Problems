#!/usr/bin/python



class AlternatingString:


  def maxLength(self,s):
    
    curLen = 1
    current = s[0]
    maxLen = curLen
    for char in s[1:]:
      if char != current:
        curLen+=1
      else:
        #same char
        if curLen > maxLen:
          maxLen = curLen
        curLen = 1

      current = char
      

    if curLen > maxLen:
      maxLen = curLen

    return maxLen


if __name__ == '__main__':
  a = AlternatingString()
  print a.maxLength("111101111")
  print a.maxLength("1010101")
  print a.maxLength("000011110000")
  print a.maxLength("1011011110101010010101")
  print a.maxLength("0")
  print a.maxLength("101000010")
  print a.maxLength("11111111111111111")

