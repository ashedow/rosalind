#!/usr/bin/env python3.6
import sys
from numpy import *

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example
from Bio import SeqIO

# Given: A quality threshold, along with FASTQ entries for multiple reads.
# Return: The number of reads whose average quality is below the threshold.

def phre():
    # I don't know why this does not work with `open with ...`
    # IndentationError: unindent does not match any outer indentation level
    input_data = open('datasets/rosalind_phre.txt')
    threshold = int(input_data.readline().rstrip())
    records = list(SeqIO.parse(input_data, 'fastq'))

    count = len([i for i in records if mean(i.letter_annotations['phred_quality']) < threshold])
    return count

print(phre())