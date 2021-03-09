package rosalind

object REVC extends App with RosalindTools {
	def reverseComlimentDNA(dna: String): String =
        dna.reverse map (ch => ch match {
            case 'T' => 'A'
            case 'A' => 'T'
            case 'G' => 'C'
            case 'C' => 'G'
            case _ => throw new Exception()
	    })
    // Need to remove new line in input file
	runWithInputOutput("input/rosalind_revc.txt")("output/REVC.txt")(reverseComlimentDNA)
}