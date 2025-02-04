import sys


def input(): return sys.stdin.readline().rstrip("\r\n")
inf = float('inf')
def fuckthisshit():
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    l = [[0] for _ in range(n)]
    z = a[::-1]
    for i in range(n):
        for j in range(n):
            l[i].append(l[i][-1] + (z[j]==b[j]))
        z = z[1:] + [z[0]]
    def lefty(i,j):
        return (j - i + n)%n
    y = [0]*(n + 1)
    p = [0]
    for i in range(n):
        p.append(p[-1] + (a[i]==b[i]))
    u = p[-1]
    for l in range(n):
        for r in range(l,n):
            delta = lefty(l,n - r - 1)
            uff = l[delta][r + 1] - l[delta][l] + u - (p[r + 1] -p[l])
            y[uff]+=1
    for  x in y:print(x)

            
fuckthisshit()