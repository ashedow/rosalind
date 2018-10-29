#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example
from Bio.Seq import translate, CodonTable

# Given: A DNA string s of length at most 10 kbp, and a protein string translated by s.
# Return: The index of the genetic code variant that was used for translation. (If multiple solutions exist, you may return any one.)

def ptra():
    with open('datasets/rosalind_ptra.txt') as input_data:
	    dna, protein = [line.strip() for line in input_data.readlines()]

    for table_id in CodonTable.ambiguous_generic_by_id.keys():
        if translate(dna, table = table_id, stop_symbol = '', to_stop=False) == protein:
            index_gen_code = str(table_id)
            break
    return index_gen_code

print(ptra())