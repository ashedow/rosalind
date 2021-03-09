package rosalind

object PROT extends App with RosalindTools {

    def rnaToProt(rna: String): String = 
	  (for (codon <- rna.grouped(3)) yield codon_table(codon)).mkString

    runWithInputOutput("input/rosalind_prot.txt")("output/PROT.txt")(rnaToProt)

}