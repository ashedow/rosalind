'''
Rosalind problem
Title: Computing GC Content
Rosalind ID: GC
URL: http://rosalind.info/problems/gc/
'''

import urllib
import contextlib

def ReadFASTA(data_location):
        '''Determines the data type of the FASTA format data and passes the appropriate information to be parsed.'''
        
        # If given a list, return fasta information from all items in the list.
        if type(data_location) == list:
                fasta_list =[]
                for location in data_location:
                        fasta_list+=ReadFASTA(location)
                return fasta_list


        # Check for a text file, return fasta info from the text file.
        if data_location[-4:] == '.txt':
                with open(data_location) as f:
                        return ParseFASTA(f)
        
        # Check for a website, return fasta info from the website.
        elif data_location[0:4] == 'http':
                with contextlib.closing(urllib.urlopen(data_location)) as f:
                        return ParseFASTA(f)

def ParseFASTA(f):
        '''Extracts the Sequence Name and Nucleotide/Peptide Sequence from the a FASTA format file or website.'''
        fasta_list=[]
        for line in f:

                # If the line starts with '>' we've hit a new DNA strand, so append the old one and create the new one.
                if line[0] == '>':
                        
                        # Using try/except because intially there will be no current DNA strand to append.
                        try:
                                fasta_list.append(current_dna)
                        except UnboundLocalError:
                                pass

                        current_dna = [line.lstrip('>').rstrip('\n'),'']

                # Otherwise, append the current DNA line to the current DNA
                else:
                        current_dna[1] += line.rstrip('\n')
        
        # Append the final DNA strand after reading all the lines.
        fasta_list.append(current_dna)

        return fasta_list

def max_gc_content(seq_list):
    gc_content = lambda seq: sum([100.0 for base in seq if base in ('G', 'C')])/len(seq)  # 100 to scale result to %.
    gc_list = [[seq_name, gc_content(seq)] for seq_name, seq in seq_list]
    return max(gc_list, key=lambda x: x[1])


def main():
    seq_list = ReadFASTA('datasets/rosalind_gc.txt')
    highest_gc = map(str, max_gc_content(seq_list))

    print (highest_gc)
    with open('result/005_GC.txt', 'w') as output_data:
        output_data.write('\n'.join(highest_gc))

if __name__ == '__main__':
    main()