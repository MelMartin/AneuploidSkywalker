import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BitSequence {
	
	byte[] bitSeq=new byte[1];
	
	

	public BitSequence(String strSeq){
		
		bitSeq=bitSequence(strSeq);
	}

	public BitSequence(BitSequence bs) {//copy constructor
		bitSeq=new byte[bs.size()];
		for (int i=0;i<bs.size();i++){
			bitSeq[i]=bs.bitSeq[i];
		}
	}
	
	
	public void setBaseAtPosition(int base,int pos){
		//System.out.println("current base at pos "+pos+" : "+bitSeq[pos]);
		switch (base) {
		case 1://'A'
			bitSeq[pos] = 1;
			break;
		case 2://'C'
			bitSeq[pos] = 2;
			break;
		case 3://'G'
			bitSeq[pos] = 3;
			break;
		case 4://'T'
			bitSeq[pos] = 4;
			break;
		default:
			bitSeq[pos] = 0;
			break;
		}
		
	}
	

	
	public byte[]  bitSequence(String s) {
		byte[] bitSq=new byte[s.length()];
		int chASCII;
		for (int i = 0; i < s.length(); i++) {
			chASCII = (int) Character.toUpperCase(s.charAt(i));
			// System.out.println("processing:"+chASCII+":"+s.charAt(i)+":");
			switch (chASCII) {
			case 65://'A'
				bitSq[i] = 1;
				break;
			case 67://'C'
				bitSq[i] = 2;
				break;
			case 71://'G'
				bitSq[i] = 3;
				break;
			case 84://'T'
				bitSq[i] = 4;
				break;
			default:
				bitSq[i] = 0;
				break;
			}
		}
		//System.out.println("bitSeq:"+bitSeq);
		return bitSq;
	}
	
	public int size(){
		return bitSeq.length;
	}
	
	public byte[] getBitSeq() {
		return bitSeq;
	}

	public int[] BitSeqToInt() {
		int[] result=new int[bitSeq.length];
		for (int i=0;i<bitSeq.length;i++){
			result[i]=(int)bitSeq[i];
			System.out.print(bitSeq[i]);
		}
		System.out.println();
		return result;
	}
	
	
	public void readBitSeq(){
		
		for (int i=0;i<bitSeq.length;i++){
			System.out.print(bitSeq[i]);
		}
		System.out.println();
	}
	
	
}
