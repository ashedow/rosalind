package rosalind

object FIBD extends App with RosalindTools {

    def fib(k:Int) = {
        val delay = Stream.fill[BigInt](k-1)(BigInt(0))
        lazy val born : Stream[BigInt] = BigInt(1) #:: fibd
        lazy val died : Stream[BigInt] = delay append born
        lazy val fibd : Stream[BigInt] = BigInt(0) #::
            died.zip(fibd zip born).map {
            case (a, (b, c)) => b + c - a
            }
        (fibd zip born).map(p => p._1 + p._2)
    }
    def mortalFibRabbits(input: String): Any = {
        val Array(n, k) = input.split(" ").map{_.toInt}
        fib(k)(n-1)
    }

	// Need to remove new line in input file
	runWithInputOutput("input/rosalind_fibd.txt")("output/FIBD.txt")(mortalFibRabbits)
}