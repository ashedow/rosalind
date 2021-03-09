package rosalind

trait RosalindTools {
// object RosalindTools {
  // def ??? = throw new Error("unimplemented")

  def getInput(filename: String) = 
    io.Source.fromFile(filename).mkString.split("\r\n").toList
  
  def using[A <: {def close(): Unit}, B](param: A)(f: A => B): B =
    try { f(param) } finally { param.close() }

  def writeOutput(output: String)(data: String) =
    using (new java.io.FileWriter(output)) {
      fileWriter => fileWriter.write(data)
    }

  def runWithInput(filename: String)(func: (String) => Any) = {
    getInput(filename).foreach(
      dna => println(func(dna)))
  }

// add check and creaate dir if it doesn't exist
  def runWithInputOutput(filename: String)(output: String)(func: (String) => Any) = {
    getInput(filename).foreach(
      dna => writeOutput(output)(func(dna).toString))
  }

  val concatStrings: (String, String) => String = (s1, s2) => s1 + s2 + " "

  def parseFASTA(list:List[String]):List[(String,String)] = list match {
	  case Nil => Nil
	  case h::t => {
	    val (a, b) = t span ( line => !(line startsWith ">"))
	    (h.substring(1), a.mkString)::parseFASTA(b)
	  }
	}

   val codon_table = Map(
    "UUU" -> 'F',    "CUU" -> 'L',    "AUU" -> 'I',    "GUU" -> 'V',
    "UUC" -> 'F',    "CUC" -> 'L',    "AUC" -> 'I',    "GUC" -> 'V',
    "UUA" -> 'L',    "CUA" -> 'L',    "AUA" -> 'I',    "GUA" -> 'V',
    "UUG" -> 'L',    "CUG" -> 'L',    "AUG" -> 'M',    "GUG" -> 'V',
    "UCU" -> 'S',    "CCU" -> 'P',    "ACU" -> 'T',    "GCU" -> 'A',
    "UCC" -> 'S',    "CCC" -> 'P',    "ACC" -> 'T',    "GCC" -> 'A',
    "UCA" -> 'S',    "CCA" -> 'P',    "ACA" -> 'T',    "GCA" -> 'A',
    "UCG" -> 'S',    "CCG" -> 'P',    "ACG" -> 'T',    "GCG" -> 'A',
    "UAU" -> 'Y',    "CAU" -> 'H',    "AAU" -> 'N',    "GAU" -> 'D',
    "UAC" -> 'Y',    "CAC" -> 'H',    "AAC" -> 'N',    "GAC" -> 'D',
    "UAA" -> '.',	 "CAA" -> 'Q',    "AAA" -> 'K',    "GAA" -> 'E',
    "UAG" -> '.',    "CAG" -> 'Q',    "AAG" -> 'K',    "GAG" -> 'E',
    "UGU" -> 'C',    "CGU" -> 'R',    "AGU" -> 'S',    "GGU" -> 'G',
    "UGC" -> 'C',    "CGC" -> 'R',    "AGC" -> 'S',    "GGC" -> 'G',
    "UGA" -> '.',    "CGA" -> 'R',    "AGA" -> 'R',    "GGA" -> 'G',
    "UGG" -> 'W',    "CGG" -> 'R',    "AGG" -> 'R',    "GGG" -> 'G') withDefaultValue '?'

   val start_codon = "AUG"
   val start_dna_codon = "ATG"
   val stop_codons = List("UAA", "UAG", "UGA")
   val stop_dna_codons = List("TAA", "TAG", "TGA")

   val dna_codon_table = (codon_table map (entry => (entry._1.replace("U", "T"), entry._2))) withDefaultValue '?'

  val monoisotopicMass = Map(
    'A' -> 71.03711,
    'C' -> 103.00919,
    'D' -> 115.02694,
    'E' -> 129.04259,
    'F' -> 147.06841,
    'G' -> 57.02146,
    'H' -> 137.05891,
    'I' -> 113.08406,
    'K' -> 128.09496,
    'L' -> 113.08406,
    'M' -> 131.04049,
    'N' -> 114.04293,
    'P' -> 97.05276,
    'Q' -> 128.05858,
    'R' -> 156.10111,
    'S' -> 87.03203,
    'T' -> 101.04768,
    'V' -> 99.06841,
    'W' -> 186.07931,
    'Y' -> 163.06333
  )

}