


class RepeatStringEasy:
  
  def maximalLength(self,s):
    
    longest = ""
    for i in range(1,len(s)):
      
      lcsVal = self.lcs(s[0:i], s[i:])
      if len(lcsVal) > len(longest):
        longest = lcsVal
    return len(longest) * 2
    
  def lcs(self,a,b):
    #initalize grid
    lcsGrid = [[0 for y in range(len(b)+1)] for x in range(len(a)+1)]
    
    for i, x in enumerate(a):
      for j, y in enumerate(b):
        if x == y:
          lcsGrid[i+1][j+1] = lcsGrid[i][j] + 1
        else:
          lcsGrid[i+1][j+1] = max(lcsGrid[i+1][j], lcsGrid[i][j+1])
          
    out = ""
    row, col = len(a), len(b)
    while row != 0 and col != 0:
      if lcsGrid[row][col] == lcsGrid[row-1][col]:
        row -= 1
        
      elif lcsGrid[row][col] == lcsGrid[row][col-1]:
        col -= 1
        
      else:
        assert a[row-1] == b[col-1]
        out = a[row-1] + out
        row -= 1
        col -= 1
    
    return out





if __name__ == "__main__":
  rs = RepeatStringEasy()
  print rs.maximalLength("single")
