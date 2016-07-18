import sys
import itertools


map = {
    'ATA':'I', 'ATC':'I', 'ATT':'I', 'ATG':'M',
    'ACA':'T', 'ACC':'T', 'ACG':'T', 'ACT':'T',
    'AAC':'N', 'AAT':'N', 'AAA':'K', 'AAG':'K',
    'AGC':'S', 'AGT':'S', 'AGA':'R', 'AGG':'R',
    'CTA':'L', 'CTC':'L', 'CTG':'L', 'CTT':'L',
    'CCA':'P', 'CCC':'P', 'CCG':'P', 'CCT':'P',
    'CAC':'H', 'CAT':'H', 'CAA':'Q', 'CAG':'Q',
    'CGA':'R', 'CGC':'R', 'CGG':'R', 'CGT':'R',
    'GTA':'V', 'GTC':'V', 'GTG':'V', 'GTT':'V',
    'GCA':'A', 'GCC':'A', 'GCG':'A', 'GCT':'A',
    'GAC':'D', 'GAT':'D', 'GAA':'E', 'GAG':'E',
    'GGA':'G', 'GGC':'G', 'GGG':'G', 'GGT':'G',
    'TCA':'S', 'TCC':'S', 'TCG':'S', 'TCT':'S',
    'TTC':'F', 'TTT':'F', 'TTA':'L', 'TTG':'L',
    'TAC':'Y', 'TAT':'Y', 'TAA':'_', 'TAG':'_',
    'TGC':'C', 'TGT':'C', 'TGA':'_', 'TGG':'W'
}


#def findStart (s):
#    for i in :
#        if == 'AUG'
#            s = s[i:]
#    return s

def transDnaToProt (s):
    
    #s = [s.index('AUG'):]

    true_data = []
    true_data =  takewhile(not_stop, (rna[3*i:3*i+3] for i in xrange(len(rna)/3)))
    s.split('', 3)
#    findStart(s)
    
    output = ''
    i=0
    while true_data[map.get(i)] != '_':
        output = output + map.get(i)
        i += 1
    
    return output

def main():
    with open('datasets/rosalind_prot.txt') as input_data:
        s = input_data.read()
        output = transDnaToProt(s)
        print (output)
        with open('result/008_PROT.txt','w') as output:
            output.write(output)

if __name__ == '__main__':
    main()
