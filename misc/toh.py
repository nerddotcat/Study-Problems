

def main():
  
  size = 4
  
  s1 = [x for x in range(size)[::-1]]
  s2 = []
  s3 = []
  
  print "start\ns1: {}\ns2: {}\ns3: {}\n{}\n".format( s1, s2, s3, '###########')
  
  tohSolve(s1,s2,s3)
  
  print "end\ns1: {}\ns2: {}\ns3: {}\n{}\n".format( s1, s2, s3, '###########')
  
  
  
def tohSolve(cur, buf, goal):
  recTohSolve(len(cur), cur, buf, goal)

def recTohSolve(val, cur, buf, goal):
  if val > 0:
    recTohSolve(val - 1, cur, goal, buf)
    
    goal.append(cur.pop())
    
    print "c: {}\nb: {}\ng: {}\n{}\n".format( cur, buf, goal, '###########')
    
    recTohSolve(val - 1, buf, cur, goal)



if __name__ == "__main__":
  main()
