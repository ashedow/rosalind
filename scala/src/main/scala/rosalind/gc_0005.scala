// package rosalind

// object GC extends App with RosalindTools {
//     def parseFASTA(list:List[String]):List[(String,String)] = list match {
// 	  case Nil => Nil
// 	  case h::t => {
// 	    val (a, b) = t span ( line => !(line startsWith ">"))
// 	    (h.substring(1), a.mkString)::parseFASTA(b)
// 	  }
// 	}
	
// 	def GCcontent(dna:String):Double = 
// 	  dna.count(c => (c == 'G' || c =='C')) / Double.box( dna.length)
	
// 	def identifyGenome(data:List[String]):(String,Double) = {
// 	  (parseFASTA(data map (s => s.trim)) map (g => (g._1, GCcontent(g._2)))).sortWith( (first, second) => { first._2 > second._2 }).head
// 	}
	
// 	val input = getInput("rosalind_gc.txt")
	
// 	val (genome, gccontent) = identifyGenome(input) 
// 	println(genome)
// 	println("%f".format( gccontent * 100) + "%")



// 	returnHighestGCContentStringId()

// 	runWithInputOutput("input/rosalind_gc.txt")("output/GC.txt")(returnHighestGCContentStringId)
// }