#!/usr/bin/env python3.6
import os
# Given: A DNA string s of length at most 1000 bp.
# Return: Four integers (separated by spaces) representing the respective number of times that the symbols 'A', 'C', 'G', and 'T' occur in s. Note: You must provide your answer in the format shown in the sample output below.

def count_nucleotides():
    f = open("datasets/rosalind_dna.txt", 'r')
    raw_seq = f.readline().rstrip()
    f.close()

    print (raw_seq.count("A"))
    print (raw_seq.count("C"))
    print (raw_seq.count("G"))
    print (raw_seq.count("T"))

print(count_nucleotides())