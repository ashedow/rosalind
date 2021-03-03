'''
Rosalind problem
Title: Rabbits and Recurrence Relations
Rosalind ID: FIB
URL: http://rosalind.info/problems/fib/
'''

def fib(n,k):
    '''Returns the number of rabbits present after n generations with litters of k pairs.'''
    rabbits = [0,1]
    for i in xrange(n-1):
        rabbits[i % 2] = rabbits[(i-1) % 2] + k*rabbits[i % 2]

    return rabbits[n % 2]
    point = []
    for i in range(0, len(string)-len(substring)+1):
        if string[i:i+len(substring)] == substring:
            point.append(str(i+1))
    return point

def main():
    with open('datasets/rosalind_fib.txt') as input_data:
        n, k = map(int, input_data.read().strip().split())

    rabbits = str(fib(n,k))

    print (rabbits)
    with open('result/004_FIB.txt', 'w') as output_data:
        output_data.write(rabbits)

if __name__ == '__main__':
    main()