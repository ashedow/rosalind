package rosalind

// object LCSM extends App with RosalindTools {
// 	def longestSubstring(dna: String): BigDecimal = {
//     }
//     def getMinLength(strings:List[String]):Int =
// 	  //(strings map (w => w.length)).min       // this version is easier to read, but i think its slower
// 	  strings.foldLeft(Int.MaxValue)((minLength, word) => Math.min(minLength, word.length))
	  
// 	def getCommonSubstrings(one:String, two:String):Stream[String] = 
// 	    for (length <- (1 to getMinLength(List(one,two))).reverse.toStream;
// 	    		sub <- one.toList.sliding(length); if (two.indexOf(sub.mkString) > -1)) yield sub.mkString
	
// 	def filterSubstrings(substrings:Stream[String], superString:String):Stream[String] = 
// 	  substrings.filter(sub => superString.contains(sub))
	
// 	def getCommonSubstrings(strings:List[String]):Stream[String] = strings match {
// 	  case Nil | _::Nil => empty
// 	  case one::two::Nil => getCommonSubstrings(one, two)
// 	  case first::second::rest => {
// 	    rest.foldLeft(getCommonSubstrings(first,second) ) {
// 	      (substrings:Stream[String], nextString:String) => filterSubstrings(substrings, nextString)
// 	    }
// 	  }
// 	}
  
// 	val words = getInput("input/rosalind_lcsm.txt")	
// //	getCommonSubstrings(words.take(2)).take(50).foreach(println)

//   	getCommonSubstrings(words) match {
// 	  case Stream() => println("None found")
// 	  case sub #:: more => println(sub)
// 	}
// 	// runWithInputOutput("input/rosalind_lcsm.txt")("output/LCSM.txt")(longestSubstring)
// }






// object LongestCommonSubsequence {
  
//     /**
//      * Find longest common subsequence using recursion
//      */
//     def longestCommonSubsequenceNaive(s1: String, s2: String): String = {
//         if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) ""
//         else if (s1 == s2) s1
//         else {
//             if (s1.head == s2.head) s1.head + longestCommonSubsequenceNaive(s1.substring(1), s2.substring(1))
//             else {
//                 val lcs1 = longestCommonSubsequenceNaive(s1, s2.substring(1))
//                 val lcs2 = longestCommonSubsequenceNaive(s1.substring(1), s2)
                
//                 if (lcs1.length() > lcs2.length()) lcs1
//                 else lcs2
//             }
//         }
//     }
    
//     /**
//      * Find longest common subsequence using Dynamic Programming
//      */
//     def longestCommonSubsequenceDP(s1: String, s2: String): String = {
//         if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) ""
//         else if (s1 == s2) s1
//         else {
//              val up = 1
//              val left = 2
//              val charMatched = 3
             
//              val s1Length = s1.length()
//              val s2Length = s2.length()
             
//              val lcsLengths = Array.fill[Int](s1Length + 1, s2Length + 1)(0)
             
//              for (i <- 0 until s1Length) {
//                  for (j <- 0 until s2Length) {
// 	                 if (s1.charAt(i) == s2.charAt(j)) {
// 	                     lcsLengths(i + 1)(j + 1) = lcsLengths(i)(j) + 1
// 	                 } else {
// 	                     if (lcsLengths(i)(j + 1) >= lcsLengths(i + 1)(j)) {
// 	                         lcsLengths(i + 1)(j + 1) = lcsLengths(i)(j + 1)
// 	                     } else {
// 	                         lcsLengths(i + 1)(j + 1) = lcsLengths(i + 1)(j)
// 	                     }
// 	                 }
//                  }
//              }
             
//              val subSeq = new StringBuilder()
//              var s1Pos = s1Length
//              var s2Pos = s2Length
             
//              // build longest subsequence by backtracking
//              do {
//                 if (lcsLengths(s1Pos)(s2Pos) == lcsLengths(s1Pos -1)(s2Pos)) {
//                     s1Pos -= 1
//                 } else if (lcsLengths(s1Pos)(s2Pos) == lcsLengths(s1Pos)(s2Pos - 1)) {
//                     s2Pos -= 1
//                 } else {
//                     assert(s1.charAt(s1Pos - 1) == s2.charAt(s2Pos - 1))
//                     subSeq += s1.charAt(s1Pos - 1)
//                     s1Pos -= 1
//                     s2Pos -= 1
//                 }
               
//              } while (s1Pos > 0 && s2Pos > 0)
               
//              subSeq.toString.reverse  
//         }
//     }

// }


import scala.io.Source

object LCSM extends App with RosalindTools {

  case class Node(var children:Array[Node] = Array.fill(4)(null)) {
    var occursCount = 0
  }

  def idx : Char => Int = {
    case 'A' => 0
    case 'C' => 1
    case 'G' => 2
    case 'T' => 3
  }

  def charOf : Int => Char = "ACGT".charAt(_)

  def longestCommonSubstring(n:Node,size:Int) : (Int,String) = {
    val x = n.children.zipWithIndex.filter(p => p._1 != null && p._1.occursCount == size)
    if (x.isEmpty) {
      (0,"")
    } else {
      x.map{
        case (child,k) => longestCommonSubstring(child,size) match {
          case (lgth,s) => (lgth+1,charOf(k) + s)
        }
      }.max
    }
  }

  override def main(args: Array[String]): Unit = {
    val lines = Source.fromFile("input/rosalind_lcsm.txt").getLines
    val dna = lines.foldLeft(List[(String,String)]()) {
      case (l,s) if s.startsWith(">") => (s.tail,"") :: l
      case (l,s) => (l.head._1,l.head._2 + s) :: l.tail
    }
    var root = Node()
    var nodeReused = 0
    dna.zipWithIndex.foreach {
      case ((name, s),i) => {
        s.foldLeft(List(root)) {
          case (l, c) => root :: l.map {
            n =>
              if (n.children(idx(c)) == null)
                n.children(idx(c)) = Node()
              if (n.children(idx(c)).occursCount == i) n.children(idx(c)).occursCount += 1
              n.children(idx(c))
          }
        }
      }
    }
    writeOutput("output/LCSM.txt")(longestCommonSubstring(root,dna.size)._2)
  }
}