#!/usr/bin/env python3.6

from Bio.Seq import Seq
from Bio.Alphabet import IUPAC

# Recall that in a DNA string s, 'A' and 'T' are complements of each other, as are 'C' and 'G'. Furthermore, the reverse complement of s is the string sc formed by reversing the symbols of s and then taking the complement of each symbol (e.g., the reverse complement of "GTCA" is "TGAC").
# The Reverse Complement program from the SMS 2 package can be run online here.

# Given: A collection of n (n≤10) DNA strings.
# Return: The number of given strings that match their reverse complements.

def rvco():
    count=0
    with open('datasets/rosalind_rvco.txt','r') as inp:
        line=inp.read().split('\n')
        prova=range(0,len(line)-2,3)
        for i in prova:
            if line[i+1].strip()+line[i+2].strip()==Seq(line[i+1].strip()+line[i+2].strip(),IUPAC.unambiguous_dna).reverse_complement():
                count+=1
    return count

# with open('ouputrvco.txt','w') as out:
#     out.write(str(count))

print(rvco())