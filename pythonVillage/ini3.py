#!/usr/bin/env python3.6
import sys
import os

# Given: A string s of length at most 200 letters and four integers a, b, c and d.
# Return: The slice of this string from indices a through b and c through d (with space in between), inclusively. In other words, we should include elements s[b] and s[d] in our slice.

def ini3():
    f = open("datasets/rosalind_ini3.txt", 'r')
    s, num = f.read().strip().split('\n')[:2]
    f.close()
    a, b, c, d = [int(x) for x in num.split()]
    result = s[a:b+1] + " " + s[c:d+1]
    return result

print(ini3())
