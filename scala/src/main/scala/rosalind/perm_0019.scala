package rosalind

object PERM extends App with RosalindTools {

    def perm(n:Int) : List[List[Int]]= {
      if (n <= 0) List(List())
      else {
        for {
          p <- perm(n-1)
          k <- n-1 to 0 by -1
        } yield { p.take(k) ++ (n :: p.drop(k))}
      }
    }

    def numOfPermutations(input: String): Any = {
        val p = perm(input.toInt)
        val out = p.map{_.mkString(" ")}.mkString("\n")
        p.length + "\n" + out
    }

	// Need to remove new line in input file
	runWithInputOutput("input/rosalind_perm.txt")("output/PERM.txt")(numOfPermutations)
}