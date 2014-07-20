/*Author: Josh Blitz*/

import java.io.*;
import java.util.ArrayList;

public class UPCPrinter
{	
	// stores 95 bit UPC-A codes
	private static ArrayList<StringBuilder> outputCodes = new ArrayList<StringBuilder>();
	static int invalid = 0;
	
	public static void main(String...args)
	{
		String inputFilename;
		String outputType;
		ArrayList<String> inputCodes = new ArrayList<String>();
		
		
		// obtain filename and output destination
		System.out.println("Enter the input filename in the following format 'name.txt' without quotes.");
		inputFilename = System.console().readLine();
		System.out.println("Enter f to output to file or c to output console.");
		outputType = System.console().readLine().toLowerCase();
		
		// output type validation possible while loop to prevent restarting
		if(!(outputType.equals("c") || outputType.equals("f")))
			System.out.println("Incorrect output format. Please restart program.");
		
		// file i/o
		try{
			BufferedReader br = new BufferedReader(new FileReader(inputFilename));
			String line = null;
			
			// make sure EOF not reached, read all lines, store in ArrayList
			while((line=br.readLine())!=null)
			{
				// length 12 and numeric only
				if(line.length()>12 && line.substring(0,12).matches("[0-9]{12}"))
				{
					inputCodes.add(line.substring(0,12));
					//System.out.println(line.substring(0,12));
				}
				else{invalid++; continue;}
			}
			br.close();
		}
		catch(FileNotFoundException fnfe)
		{System.out.println("File not found. Please restart program.");return;}
		catch(IOException ioe)
		{ioe.printStackTrace();return;}
		
		// iterate through ArrayList and convert each valid code into correct binary String
		
		for(String s:inputCodes)
			processNumericCodes(s.toCharArray());
		
		//System.out.println(outputCodes);
		
		//output UPC-A
		printUPC(outputType);
	}
	
	// L vs R is a bitwise NOT
	// iterate through each numeric code and convert to binary String, then add to outputCodes
	private static void processNumericCodes(char [] number)
	{
		String enclosing = "101";
		String middle = "01010";
		StringBuilder sb = new StringBuilder(enclosing);
		for(int i=0;i<number.length;i++)
		{
			String x = null;
			switch(number[i])
			{
				case '0': x= i<5 ? "0001101" : "1110010";break;
				case '1': x= i<5 ? "0011001" : "1100110";break;
				case '2': x= i<5 ? "0010011" : "1101100";break;
				case '3': x= i<5 ? "0111101" : "1000010";break;
				case '4': x= i<5 ? "0100011" : "1011100";break;
				case '5': x= i<5 ? "0110001" : "1001110";break;
				case '6': x= i<5 ? "0101111" : "1010000";break;
				case '7': x= i<5 ? "0111011" : "1000100";break;
				case '8': x= i<5 ? "0110111" : "1001000";break;
				case '9': x= i<5 ? "0001011" : "1110100";break;
			}
			sb.append(x);
		}
		sb.append(enclosing);
		sb.insert(48,middle);
		outputCodes.add(sb);
		//System.out.println(sb.length());
	}
	
	private static void printUPC(String o)
	{
		// console output
		if(o.equals("c"))
		{
			for(StringBuilder code:outputCodes)
			{
				for(int i=0; i<code.length(); i++)
				{
					if(code.charAt(i)=='1')System.out.print("|");
					else System.out.print(" ");
				}
				System.out.println();
			}
		}
		// file output
		else
		{
			try
			{
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
				for(StringBuilder code:outputCodes)
				{
					for(int i=0; i<code.length(); i++)
					{
						if(code.charAt(i)=='1')pw.print("|");
						else pw.print(" ");
					}
					pw.println();
				}
				pw.close();
			}
			catch(Exception e){e.printStackTrace();}
		}
		System.out.println("Invalid codes detected: "+invalid);
	}
}