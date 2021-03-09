package rosalind

object HAMM extends App with RosalindTools {
    def hammingDistance(s: String, t: String): Int = (s, t) match {
        case (s, t) if (s.length == t.length) => (s zip t).count(pair => pair._1 != pair._2)
        case _ => throw new IllegalArgumentException()
    }

    def dnaHamm(input: String): Int = {
        val Array(s, t) = input.split("\n")
        hammingDistance(s, t)
    }
    runWithInputOutput("input/rosalind_hamm.txt")("output/HAMM.txt")(dnaHamm)

}