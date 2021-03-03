#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example

# Given: Two GenBank IDs.
# Return: The maximum global alignment score between the DNA strings associated with these IDs.?


def regular_creator():
    with open("datasets/rosalind_need.txt", 'r') as input_data:
	    IDs1, IDs2 = input_data.read().strip()

    

    return max_global_score

print(regular_creator())