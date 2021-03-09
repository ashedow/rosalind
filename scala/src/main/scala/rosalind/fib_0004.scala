package rosalind

object FIB extends App with RosalindTools {

	def fibRabbits(input: String): Long = {
        val Array(n, k) = input.split(" ").map{_.toLong}

		rabbits_alive(n, k)  match {
			case (newborn, adult) => newborn + adult
		}
    }

	def rabbits_alive(month: Long, rabbit: Long): (Long, Long) = month match {
	    case 1 => (1, 0)
		case x => val previous = rabbits_alive(month - 1, rabbit)
      (rabbit * previous._2, previous._1 + previous._2)

	}
	// Need to remove new line in input file
	runWithInputOutput("input/rosalind_fib.txt")("output/FIB.txt")(fibRabbits)
}