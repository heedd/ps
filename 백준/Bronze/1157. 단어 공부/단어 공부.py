import sys
input = sys.stdin.readline
from collections import Counter

str = input().rstrip().upper()
val = Counter(str).most_common(2)

if len(val) == 1 :
  print(val[0][0])
elif val[0][1] == val[1][1] :
    print('?')
else : 
    print(val[0][0])