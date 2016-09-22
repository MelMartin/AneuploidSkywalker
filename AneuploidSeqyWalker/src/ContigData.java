import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class ContigData {

	String contigName;
	
	int length;

	byte[] bitSeq;
	DirectedGraph<SeqGraphNode, DefaultEdge> seqGraph = new DefaultDirectedGraph<>(DefaultEdge.class);
	

	public ContigData(String name, String seq) {
		contigName = name;		
		bitSeq=bitSequence(seq);
		seqGraph=createSeqGraph( bitSeq,1);
		System.out.println("new ContigData "+name+" seq:"+seq);
	}


	public String getContigName() {
		return contigName;
	}

	public byte[]  bitSequence(String s) {
		byte[] bitSq=new byte[s.length()];
		int chASCII;
		for (int i = 0; i < s.length(); i++) {
			chASCII = (int) Character.toUpperCase(s.charAt(i));
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
		return bitSq;
	}
	
	public byte[] copyCloneBitSequence(BitSequence bs) {//copy clone
		byte[]newBitSeq=new byte[bs.size()];
		for (int i=0;i<bs.size();i++){
			newBitSeq[i]=bs.bitSeq[i];
		}
		return newBitSeq;
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
	
	private static DirectedGraph<SeqGraphNode, DefaultEdge> createSeqGraph(byte[] bitSeq ,int cn)
    {
        DirectedGraph<SeqGraphNode, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

        try {
        	SeqGraphNode originalContigNode = new SeqGraphNode(bitSeq,cn);
        	g.addVertex(originalContigNode);
        	/*
            // add the vertices
            g.addVertex(vertice1);
          	g.addVertex(vertice2);
            // add edges to create linking structure
            g.addEdge(vertice1, vertice2);
        	*/
        } catch (Error e) {
        	System.out.println("Error creating Seq Graph");
            e.printStackTrace();
        }

        return g;
    }
	
	public void printContigGraph(){
		Set <SeqGraphNode> nodeSet=  seqGraph.vertexSet();
		Iterator <SeqGraphNode> it= nodeSet.iterator();		
		
	     while(it.hasNext()){
	    	it.next().printNode();
	        //System.out.println(" ::"+(it.next().bitSeqToInt()));
	     }
	
	}
	
}
