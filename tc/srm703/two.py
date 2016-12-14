#!/usr/bin/python

from fractions import gcd

class GCDGraph:


  def possible(self,n,k,x,y):
    if x < k || y < k:
      return "Impossible"
    return self.bfs(n,k,x,y)

  def bfs(self,n,k,x,y):
    notSeen = range(k,n+1)

    toVisit = [x]
    notSeen.remove(x)

    while(toVisit):
      cur = toVisit.pop(0)
      #print "v:", cur

      if cur == y:
        return "Possible"
      toRemove = []
      #check for connections
      for val in notSeen:
        if gcd(val,cur) > k:
          toRemove.append(val)
          toVisit.append(val)
      for val in toRemove:
        notSeen.remove(val)

    return "Impossible"


if __name__ == '__main__':
  a = GCDGraph()
  print a.possible(12,2,8,9)
  print a.possible(12,2,11,12)
  print a.possible(12,2,11,11)
  print a.possible(10,2,8,9)
  print a.possible(1000000,1000,12345,54321)
  print a.possible(2,0,1,2)