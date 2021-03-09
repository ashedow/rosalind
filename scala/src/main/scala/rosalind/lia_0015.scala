package rosalind

object LIA extends App with RosalindTools {

    lazy val factorial : Stream[BigInt] = BigInt(1) #:: factorial.zipWithIndex.map(p => p._1 * (p._2+1))

    def choose(n:Int,k:Int) : Double = {
        (factorial(n) / factorial(k) / factorial(n - k)).toDouble
    }

    def MendelSecondLaw(input: String): Double = {
        val Array(k, n) = input.split(" ").map{_.toInt}

        val children = 1 << k
        (n to children).foldLeft(0.0) {
            case (p:Double,i) => p + choose(children,i) * Math.pow(0.25,i) * Math.pow(0.75,children-i)
        }
    }
	runWithInputOutput("input/rosalind_lia.txt")("output/LIA.txt")(MendelSecondLaw)
}