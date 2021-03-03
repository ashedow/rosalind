'''
Rosalind problem
Title: Counting DNA Nucleotides
Rosalind ID: DNA
URL: http://rosalind.info/problems/dna
'''

f = open("datasets/rosalind_dna.txt", 'r')
raw_seq = f.readline().rstrip()
f.close()

print raw_seq.count("A"),
print raw_seq.count("C"),
print raw_seq.count("G"),
print raw_seq.count("T")