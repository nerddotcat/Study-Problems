#!/usr/bin/python


def main():
  things = [1,2,3]
  
  #simplePermute(things)
  swapPermute(things,len(things),0)
  

def swapPermute(vals, n, i ):
  if i == n:
    print vals
    return
  
  for x in range(i,n):
    swap(vals,i,x)
    swapPermute(vals,n,i+1)
    swap(vals,x,i)


def swap(vals, a, b):
  vals[a],vals[b] = vals[b],vals[a]


def simplePermute(vals,out=[]):
  if not len(vals):
    print out
  
  for i in range(len(vals)):
    temp = vals[:]
    current = temp.pop(i)
    simplePermute(temp,out + [current])


if __name__ == '__main__':
  main()
