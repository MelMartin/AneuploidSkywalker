
public class SeqGraphNode {
	byte[] bitSeq;
	int length;
	Integer[] chromosomeCopy;
	
	
	public SeqGraphNode(byte[] bitSeq, int copyNumber){
		this.bitSeq=bitSeq;
	}

	public int[] bitSeqToInt() {
		
		int[] result=new int[bitSeq.length];
		for (int i=0;i<bitSeq.length;i++){
			result[i]=(int)bitSeq[i];
			System.out.print(bitSeq[i]);
		}
		System.out.println();
		return result;
	}
	
	public void printNode(){
		System.out.print("(");
		int[] result=new int[bitSeq.length];
		for (int i=0;i<bitSeq.length;i++){
			result[i]=(int)bitSeq[i];
			System.out.print(bitSeq[i]);
		}
		System.out.println(")");
	}
}
