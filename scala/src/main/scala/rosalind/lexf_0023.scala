package rosalind

object LEXF extends App with RosalindTools {
    def getOrderedKmers(alphabet: List[String], k: Int): List[String] =
        (0 until k).foldLeft(List("")){ case (acc, _) => acc.flatMap(nMer => alphabet.map(nMer + _)) }

    def getLexfStr(input: String): Any = {
        val Array(alphabet, n) = input.split("\n")
        // println(alphabet)
        // println(n)
        getOrderedKmers(alphabet.split(" ").toList, n.toInt).fold("")(concatStrings)
    }

	// Need to remove new line in input file
	runWithInputOutput("input/rosalind_lexf.txt")("output/LEXF.txt")(getLexfStr)
}