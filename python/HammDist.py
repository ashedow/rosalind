import sys

def hamming_distance(s, t):
    dh = 0

    for i, c in enumerate(s):
        if c != t[i]:
            dh += 1
    return dh

large_dataset = open('datasets/rosalind_hamm.txt').read()

s, t = large_dataset.split()
dist = hamming_distance(s, t)

print dist

"""
for i in range(lenStr):
    if inputStr1[i] != inputStr2[i]:
        hammDist = hammDist + 1
    else:
        continue 

print (hammDist)
"""
