package rosalind

object IEV extends App with RosalindTools {
	def numDomPhenotype(dna: String): BigDecimal = {
        val Array(k, l, m, n, o, p) = dna.split(" ").map{_.toInt}
        k * 2.0 + l * 2.0 + m * 2.0 + n * 1.5 + o
    }
	runWithInputOutput("input/rosalind_iev.txt")("output/IEV.txt")(numDomPhenotype)
}