#!/usr/bin/python


def main():
  things = [1,2,3]
  
  simplePermute(things)
  


def simplePermute(vals,out=[]):
  if not len(vals):
    print out
  
  for i in range(len(vals)):
    temp = vals[:]
    current = temp.pop(i)
    simplePermute(temp,out + [current])


if __name__ == '__main__':
  main()
