#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example
from Bio import Entrez

# Given: A genus name, followed by two dates in YYYY/M/D format.
# Return: The number of Nucleotide GenBank entries for the given genus that were published between the dates specified.

def gen_bank():
    with open("datasets/rosalind_gbk.txt", 'r') as input_data:
	    gen, start_date, end_date = [line.strip() for line in input_data.readlines()]

    query = '({}[Organism]) AND ("{}"[Publication Date] : "{}"[Publication Date])'.format(
        gen, start_date, end_date)
    record = Entrez.read(Entrez.esearch(db='nucleotide', term=query))

    return record['Count']

print(gen_bank())