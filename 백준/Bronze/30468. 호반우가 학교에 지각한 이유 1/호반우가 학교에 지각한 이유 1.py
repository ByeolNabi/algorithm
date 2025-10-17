c = list(map(int, input().split()))

tSum = sum(c[:4])
q = c[4]

print((q*4 - tSum) if (q*4 - tSum) >= 0 else 0)