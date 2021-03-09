package rosalind

object SUBS extends App with RosalindTools {
    def subsLocations(input: String): IndexedSeq[Int] = {
        val Array(dna, subs) = input.split("\n")
        (0 to dna.length-1).filter(i => dna.indexOf(subs,i) == i).map(_ + 1) //fold("")(concatStrings)
    }

    runWithInputOutput("input/rosalind_subs.txt")("output/SUBS.txt")(subsLocations)

}