#!/usr/bin/env python3.6
import sys
import os

# Given: A string s of length at most 10000 letters.
# Return: The number of occurrences of each word in s, where words are separated by spaces. Words are case-sensitive, and the lines in the output can be in any order.

def ini6():
    f = open("datasets/rosalind_ini6.txt", 'r')
    text = f.read().strip().split()
    f.close()
    count_dict = {}
    for world in text:
        if world in count_dict:
            count_dict[world] +=1
        else:
            count_dict[world] = 1
    return count_dict

print(ini6())