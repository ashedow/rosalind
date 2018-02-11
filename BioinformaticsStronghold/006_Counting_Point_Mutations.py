'''
Rosalind problem
Title: Counting Point Mutations
Rosalind ID: HAMM
URL: http://rosalind.info/problems/hamm/
'''

def hamming_distance(s, t):
    dh = 0

    for i, c in enumerate(s):
        if c != t[i]:
            dh += 1
    return dh

def main():
    with open('datasets/rosalind_hamm.txt') as input_data:
        s, t = input_data.split()
        
    dist = hamming_distance(s, t)

    print (dist)
    with open('result/004_HAMM.txt', 'w') as output_data:
        output_data.write(dist)

if __name__ == '__main__':
    main()