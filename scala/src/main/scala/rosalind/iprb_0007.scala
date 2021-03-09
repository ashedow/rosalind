package rosalind

object IPRB extends App with RosalindTools {
    def MendelianInheritance(k: Int, m: Int, n: Int): BigDecimal = {
        val N = k + m + n
        BigDecimal.apply(k * (k - 1 + 2 * (m + n)) + .75 * m * (m - 1) + m * n ) / ( N * (N - 1))
    }

    def probDominantPhenotype(input: String): BigDecimal = {
        val Array(k, m, n) = input.split(" ").map{_.toInt}
        MendelianInheritance(k, m, n)
    }
    runWithInputOutput("input/rosalind_iprb.txt")("output/IPRB.txt")(probDominantPhenotype)

}