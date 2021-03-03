from Bio.Seq import Seq
from Bio.Alphabet import IUPAC

def rna2prot(rna):
    rna = Seq(rna, IUPAC.unambiguous_rna)
        return str(rna.translate(to_stop=True))
