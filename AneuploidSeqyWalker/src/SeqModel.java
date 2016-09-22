import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

public class SeqModel {

	List<ContigData> contigsDataArray;
	
	
	public SeqModel(List<ContigData> refContArr){
		contigsDataArray=refContArr;
		for (int i=0;i<refContArr.size();i++){
			refContArr.get(i).printContigGraph();
		}
		/*
		
			// note directed edges are printed as: (<v1>,<v2>) undirected edges are printed as: {<v1>,<v2>}
			System.out.println(seqGraphsArray.get(cs).toString());
		}
		*/
	}
	
	
}
