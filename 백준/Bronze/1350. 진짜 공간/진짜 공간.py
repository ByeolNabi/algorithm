N = int(input())
files = list(map(int,input().split()))
size = int(input())

cnt = 0;
for f in files:
  c = f/size
  ic = int(c)
  if(c == int(c)):
    cnt += ic
  else:
    cnt += ic+1

print(cnt * size)