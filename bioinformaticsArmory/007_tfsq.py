#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example
from Bio import SeqIO

# Given: FASTQ file
# Return: Corresponding FASTA records

def tfsq():
    with open('datasets/rosalind_tfsq.txt') as input_data, open('datasets/007_TFSQ.txt', 'w') as output_data:
	    SeqIO.convert(input_data, 'fastq', output_data, 'fasta' )
        print('Done. Look answer in datasets/007_TFSQ.txt')