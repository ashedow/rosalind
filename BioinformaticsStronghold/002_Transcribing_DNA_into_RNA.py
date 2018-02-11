'''
Rosalind problem
Title: Transcribing DNA into RNA
Rosalind ID: RNA
URL: http://rosalind.info/problems/rna
'''

def rnaTranscript(dna):
	return dna.replace('T', 'U')

def main():
    with open('datasets/rosalind_rna.txt') as input_data:
        dna = input_data.read().strip()
    rna = rnaTranscript(dna)

    print rna
    with open('result/002_RNA.txt', 'w') as output_data:
        output_data.write(rna)

if __name__ == '__main__':
    main()