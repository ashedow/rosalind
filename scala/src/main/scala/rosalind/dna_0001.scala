package rosalind

object DNA extends App with RosalindTools {
	def pack(s:List[Char]): List[List[Char]] = s match {
	  case Nil => List()
	  case x::xs => {
		// span method lets you split a stream into two parts, by providing a function that detects the dividing line where you want the split to occur. 
	    val (start, rest) = s span (y => y == x)
	    start :: pack(rest)
	  }
	}

	def countNucleotides(dna: String): Map[Char, Int] = 
	  (pack((dna toList) sorted) map (n => (n.head -> n.length))).toMap
	
	def countNucleotidesAsString(dna: String): String = {
	  val counts = countNucleotides(dna)
	  counts('A')+" "+counts('C')+" "+counts('G')+" "+counts('T')
	}

	runWithInputOutput("input/rosalind_dna.txt")("output/DNA.txt")(countNucleotidesAsString)
}