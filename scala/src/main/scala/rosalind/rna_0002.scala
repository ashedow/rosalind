package rosalind

object RNA extends App with RosalindTools {
	def transcribeRNA(dna: String): String =
        dna map (ch => ch match {
	    case 'T' => 'U'
	    case _ => ch
	  })

	runWithInputOutput("input/rosalind_rna.txt")("output/RNA.txt")(transcribeRNA)
}