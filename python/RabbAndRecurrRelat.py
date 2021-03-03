import sys


def rab_fib (n, k):
    '''return rabbits after n grneration with litters of k pair'''
    rabbit = [0,1]
    '''sequence is f(n)= f(n-1) + K*f(n-2)'''
    for i in range(2, n + 1):
        rabbit.append(rabbit[i-1] + k*rabbit[i-2])

    return rabbit[n]

'''
def rab_fib (n, k):
    rabbits = [0,1]
    for i in xrange(n-1):
        rabbits[i % 2] = rabbits[(i-1) % 2] + k*rabbits[i % 2]

        return rabbits[n % 2]
'''

def main():
    with open('datasets/rosalind_fib.txt') as input_data:
        n,k = map(int, input_data.read().strip().split())
   
    rabbit = str(rab_fib(n, k))

    print (rabbit)
    with open('result/004_FIB.txt','w') as output:
        output.write(rabbit)

if __name__ == '__main__':
    main()

