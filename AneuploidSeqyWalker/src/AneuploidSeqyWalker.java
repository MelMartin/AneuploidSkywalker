import java.io.File;
import java.io.FileNotFoundException;
import java.net.*;
import java.util.Scanner;

import org.jgrapht.*;
import org.jgrapht.graph.*;

public class AneuploidSeqyWalker {

	static String inputFile="C://Users//Mel//Documents//BIOINFORMATICS//DELFT_Research//Data//Genomes//TestSimulations//testContigs.fa";

	public static void main(String[] args) {           
		
		try {
			GraphManager gm=new GraphManager(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("Input File "+inputFile+" could not be found");
			e.printStackTrace();
		}	
	}

}
