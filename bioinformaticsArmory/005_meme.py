#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example

# Given: A set of protein strings in FASTA format that share some motif with minimum length 20.
# Return: Regular expression for the best-scoring motif.



def regular_creator():
    with open("datasets/rosalind_meme.txt", 'r') as input_data:
	    stt = input_data.read().strip()
    return regular_string

print(regular_creator())