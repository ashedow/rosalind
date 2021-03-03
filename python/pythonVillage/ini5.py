#!/usr/bin/env python3.6
import sys
import os

# Given: A file containing at most 1000 lines.
# Return: A file containing all the even-numbered lines from the original file. Assume 1-based numbering of lines.

def ini5():
    i = 1
    for line in open("datasets/rosalind_ini5.txt"):
        if i%2 == 0:
            print(line)
        i += 1
   
print(ini5())