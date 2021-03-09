package rosalind

object PRTM extends App with RosalindTools {
    def weight(p:String):Double = 
        p.map(c => monoisotopicMass(c)).sum

	// Need to remove new line in input file
	runWithInputOutput("input/rosalind_prtm.txt")("output/PRTM.txt")(weight)
}