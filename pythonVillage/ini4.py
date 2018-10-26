#!/usr/bin/env python3.6
import sys
import os
# Given: Two positive integers a and b (a<b<10000).
# Return: The sum of all odd integers from a through b, inclusively.

def ini4():
    f = open("datasets/rosalind_ini4.txt", 'r')
    a, b = [int(x) for x in f.read().split()]
    f.close()
    sum = 0
    for i in range(a,b+1):
    if i%2 == 1:
        sum += i
    return sum

print(ini4())