package rosalind

object MPRT extends App with RosalindTools {
	// def findOccurrences(p:Regex)(proteinId:String):Seq[Int] = {
	  
	//   def findIndexes(indexes: Seq[Int], data:String, p:Regex, offset:Int):Seq[Int] = {
	// 	 p.findFirstMatchIn(data.substring(offset)) match {
	// 	   case None => indexes
	// 	   case Some(m) => findIndexes(indexes:+(offset+m.start+1), data, p, offset+m.start+1)
	// 	 }
	//   }
	  
	//   val proteinFasta = Source.fromURL("http://www.uniprot.org/uniprot/"+proteinId+".fasta").mkString
	//   val (pId, data) = GC.parseFASTA(proteinFasta.split('\n').toList).head
	  
	//   findIndexes(Nil, data, p, 0)
	// }


    // def findIndexes(input: String) ={
    //     // val lines = input.split("\n") // getLines () toArray
    //     val lines = input getLines () toArray
    //     val fasta = lines.map(s => ( s, Source fromURL("http://www.uniprot.org/uniprot/" + s + ".fasta") mkString ) )
    //     val prot = fasta.map {
    //         case (name,text) => ( name, Source fromString text getLines () drop 1 mkString "" )
    //     }
    //     val regex = "N[^P][ST][^P]".r
    //     val posn = prot.map {
    //     case (name,s) => { // we need to handle overlapping matches
    //         lazy val matchStream: Stream[(Option[Regex.Match], Int)] = (regex findFirstMatchIn s, 0) #:: { matchStream map {
    //         case (None, k) => (None, k)
    //         case (Some(m), k) => (regex findFirstMatchIn (s.substring(k + m.start + 1)), k + m.start + 1)
    //         } }
    //         (name, matchStream.takeWhile(_._1 != None).map { case (Some(it), k) => it.start + k + 1 })
    //     }
    //     } filter { case (_,str) => ! str.isEmpty}
    //     posn foreach { p => { println(p _1); println(p._2 mkString " ") } }
    // }

	// runWithInputOutput("input/rosalind_mprt.txt")("output/MPRT.txt")(findIndexes)
}