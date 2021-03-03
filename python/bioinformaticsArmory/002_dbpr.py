#!/usr/bin/env python3.6
import os

# Use biopython lib couse it is more effectively for this format, than urllib  or reqest with scrappy or re? for example
from Bio import ExPASy
from Bio import SwissProt

# Given: The UniProt ID of a protein.
# Return: A list of biological processes in which the protein is involved (biological processes are found in a subsection of the protein's "Gene Ontology" (GO) section).


# def read_dataset(task_name):
#     filename = 'rosalind_{}.txt'.format(task_name)
#     with open(filename) as inf:
#         return [i.strip() for i in inf.readlines()][0]

def uniprot():
    with open("datasets/rosalind_dbpr.txt", 'r') as input_data:
	    uni_id = input_data.read().strip()

    record = SwissProt.read(ExPASy.get_sprot_raw(uni_id))
    bio_process = []
    for item in record.cross_references:
        if item[0] == 'GO' and item[2][0]=='P':
            bio_process.append(item[2].lstrip('P:'))
    
    return bio_process

print(uniprot())