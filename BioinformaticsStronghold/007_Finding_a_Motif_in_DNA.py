'''
Rosalind problem
Title: Finding a Motif in DNA
Rosalind ID: SUBS
URL: http://rosalind.info/problems/subs/
'''

def motifPoint(string, substring):
    point = []
    for i in range(0, len(string)-len(substring)+1):
        if string[i:i+len(substring)] == substring:
            point.append(str(i+1))
    return point

def main():
    with open('datasets/rosalind_subs.txt') as input_data:
        string, substring = input_data.readlines()
        string = string.rstrip()
        substring = substring.rstrip()

    result = motifPoint(string, substring)

    print ' '.join(result)
    with open('result/009_SUBS.txt', 'w') as output_data:
        output_data.write(' '.join(result)

if __name__ == '__main__':
    main()