



def main():
  print lcs('aaabbbccc','2732aaabbvcc')
  print lcs('1','1111111111')
  print lcs('abcdefghijklmnopqrstuvwxyz','the quick brown fox jumps over the lazy dog')
  print lcs('cgtacgtatcgatcgacagtactacg','cgtactgactacgatatatcgcgtgatcacgtacgact')
  
  
  
def lcs(a,b):
  lengths = [[0 for y in range(len(b)+1)] for x in range(len(a)+1)]
  
  #fill grid
  for i, achar in enumerate(a):
    for j, bchar in enumerate(b):
      #print i, achar, j , bchar
      if achar == bchar:
        lengths[i+1][j+1] = lengths[i][j] + 1
      else:
        lengths[i+1][j+1]  = max(lengths[i+1][j], lengths[i][j+1] )
  
  #print lengths
  #get solution
  row, col = len(a),len(b)
  out = []
  while row != 0 and col != 0 :
    if lengths[row][col] == lengths[row][col-1]:
      col-=1
    elif lengths[row-1][col] == lengths[row][col]:
      row-=1
    else:
      out += a[row-1]
      row-=1
      col-=1
     
  return "".join(out[::-1])




if __name__ == "__main__":
  main()
