#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example
from Bio import Entrez
from Bio import SeqIO

# Given: A collection of n (n≤10) GenBank entry IDs.
# Return: The shortest of the strings associated with the IDs in FASTA format.


def data_formats():
    with open("datasets/rosalind_frmt.txt", 'r') as input_data:
	    IDs = input_data.read().strip()

    recs = SeqIO.parse(Entrez.efetch(db='nucleotide', id=IDs, rettype='fasta'), 'fasta')
    shortest_str = min(recs, key=lambda x: len(x.seq)).format('fasta')

    return shortest_str

print(data_formats())