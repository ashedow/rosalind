'''
Rosalind problem
Title: Complementing a Strand of DNA
Rosalind ID: REVC
URL: http://rosalind.info/problems/revc/
'''

def revComplement(dna):
	reversedna = dna[::-1]
	complement = reversedna.replace('A', 't').replace('T','a').replace('G', 'c').replace('C', 'g').upper()
	return complement

def main():
    with open('datasets/rosalind_revc.txt') as input_data:
        dna = input_data.read().strip()
    complementStr = revComplement(dna)

    print (complementStr)
    with open('result/003_REVS.txt', 'w') as output_data:
        output_data.write(complementStr)

if __name__ == '__main__':
    main()

