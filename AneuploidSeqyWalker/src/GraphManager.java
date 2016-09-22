import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphManager {

	SeqModel seqM;
	
	public GraphManager (String inputFile) throws FileNotFoundException{
		seqM = new SeqModel(getContigs( inputFile));		
	}
	
	public  List<ContigData> getContigs(String inputFile) throws FileNotFoundException{
		List<ContigData> refContigsArray=new ArrayList<ContigData>();
		String strSeq="";
		String line="";
		String header="";
		int n=0;
		try{
			Scanner sc = new Scanner(new File(inputFile));	
			while (sc.hasNextLine()){
				line = sc.nextLine();
				if (line.trim().isEmpty() || line.substring(0, 1).equals(">")  ){
					if (strSeq!="" && header!=""){//if there was previously a sequence
						refContigsArray.add(new ContigData(header,strSeq));
						strSeq="";
					}
					if (!line.trim().isEmpty() && line.substring(0, 1).equals(">") ){//it's a header
						header=line.substring(0, line.length());//gets new header
					}
					//else just skip 
				}else{//line is part of a sequence
					strSeq+=line;//elongate the sequence
				}
				n++;//for error tracking		
			}
		}
		catch (Exception e) {
			System.out.println("Error getContigs: could not find the inputFile or stopped at " +n+ " lines" );
		}
		return refContigsArray;
	}
}
