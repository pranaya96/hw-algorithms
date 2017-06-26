package lab7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextLayout {

    // Layout text.
    // Lay out the text contained in the List<String> words into the individual lines.
    private static List<String> layoutText(List<String> words, int maxLineWidth) {
	return greedyLayoutText(words, maxLineWidth);
	// TODO: Uncomment this after implementing prettyPrintLayoutText()
	// return prettyPrintLayoutText(words, maxLineWidth);
    }

    // Layout the text in the minimal number of lines.
    private static List<String> greedyLayoutText(List<String> words, int maxLineWidth) {
    	List<String> lines = new ArrayList<String>();
    	int i=0;
		String myLine = "";
		String temp = "";     
    	while ( i < words.size()) {

    		if ((temp.length() + myLine.length() + words.get(i).length()) <= maxLineWidth){
    			myLine += temp + words.get(i) + " ";
    			if(i == words.size()-1){
    				lines.add(myLine.trim());
    			}
    			i++;
    			temp ="";	
    		}
    		else {
    			lines.add(myLine.trim());
    			temp= words.get(i) + " ";
    			myLine="";
    			i++;
    		}
    	}
    	giveCost(lines, maxLineWidth);

    		

    
    	// System.out.println(words.get(0));
    	// System.out.println(words.get(1));
    	return lines;
    }

    public static void giveCost(List<String> lines, int maxLineWidth){
    	int cost = 0;
    	for(String line : lines){
    		int usedLen = line.length();
    		System.out.println(maxLineWidth-usedLen);
    		cost = cost + ((maxLineWidth - usedLen) *  (maxLineWidth - usedLen));
    	}
    	System.out.println("The cost is: " + cost);
    
    }


    // Layout the text minimizing the "pretty print" cost function.
    private static List<String> prettyPrintLayoutText(List<String> words, int maxLineWidth) {
	List<String> lines = new ArrayList<String>();

	////////////////////////////////
	// TODO: Write yor code here. //
	////////////////////////////////

	return lines;
    }

    public static void main(String[] args) {
	if (args.length < 2) {
	    System.out.println("Expecting 2 args: text-path and max-line-width.");
	}
	String textPath = args[0];
	int maxLineWidth = Integer.parseInt(args[1]);

	List<String> words = new ArrayList<String>();
	// Read the words from the file, and create a List with the individual words.
	try {
	    List<String> lines = Files.readAllLines(Paths.get(textPath),
						    StandardCharsets.UTF_8);
	    Scanner in = new Scanner(System.in);
	    for (String line : lines) {
		for (String token : line.trim().split("\\s+")) {
		    words.add(token);
		}
	    }
	} catch (IOException ex) {
	    ex.printStackTrace();
	}

	List<String> lines = layoutText(words, maxLineWidth);
	int lineNum = 1;
	int totalCost = 0;
	int lastLineCost = 0;
	for (String line : lines) {
	    totalCost += lastLineCost;
	    lastLineCost = (maxLineWidth - line.length()) * (maxLineWidth - line.length());
	    while (line.length() < maxLineWidth) line += " ";
	    line += "|";
	    System.out.format("%4d  %s\n", lineNum++, line);
	}
	System.out.println("Total cost: " + totalCost);
    }
}
