#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example
from Bio import SeqIO
from numpy import *

# Given: A quality threshold value q, percentage of bases p, and set of FASTQ entries.
# Return: Number of reads in filtered FASTQ entries


def filt():
    input_data = open('datasets/rosalind_filt.txt')
    threshold_q, percentage_p = [int(i) for i in input_data.readline().rstrip().split()]
    records = list(SeqIO.parse(input_data,'fastq'))

    quality = [record.letter_annotations['phred_quality'] for record in records]

    number_of_reads = len([k for k in [sum([int(j >= threshold_q) for j in i])/float(len(i)) for i in quality] if k >= percentage_p/100.])

    return number_of_reads

print(filt())