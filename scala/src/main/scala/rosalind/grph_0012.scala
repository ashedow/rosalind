package rosalind


object GRPH extends App with RosalindTools {

    def getEgesAdjacency(k:Int)(dnaInFASTA:List[(String,String)]): List[(String, String)] = {
        val heads = dnaInFASTA.groupBy(fasta => fasta._2.substring(fasta._2.length-k)) withDefaultValue List()
        val tails = dnaInFASTA.groupBy(fasta => fasta._2.substring(0,k)) withDefaultValue List()
        (for (overlap <- heads.keys; h <- heads(overlap); t <- tails(overlap); if (h._1 != t._1))
        yield (h._1, t._1)).toList
    }
    
    val dnaStrings = parseFASTA(getInput("input/rosalind_grph.txt"))
    val adjacencies = getEgesAdjacency(3)(dnaStrings) // O3 overlap
    
    println(adjacencies.foreach(pair => println(pair._1+" "+pair._2)) )

    // def getEgesAdjacency(input: String) = {
    //     val lines = Source.stdin.getLines
    //     val dna = lines.foldLeft(List[(String,String)]()) {
    //         case (l,s) if s.startsWith(">") => (s.tail,"") :: l
    //         case (l,s) => (l.head._1,l.head._2 + s) :: l.tail
    //     }
    //     val arcs = for {
    //         s <- dna
    //         d <- dna
    //         if s._1 != d._1
    //         if s._2.substring(s._2.length-3) == d._2.substring(0,3)
    //     } yield (s._1,d._1)
    //     println(arcs.map(p => p._1 + " " + p._2).mkString("\n"))
    // }

    // runWithInputOutput("input/rosalind_grph.txt")("output/GRPH.txt")(getEgesAdjacency)
}