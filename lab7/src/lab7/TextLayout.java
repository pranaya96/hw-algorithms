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
    }

    // Layout the text in the minimal number of lines.
    private static List<String> greedyLayoutText(List<String> words, int maxLineWidth) {
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
	for (String line : lines) {
	    while (line.length() < maxLineWidth) line += " ";
	    line += "|";
	    System.out.format("%4d  %s\n", lineNum++, line);
	}
    }
}
