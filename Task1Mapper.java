/**
 * 
 */
package Assignment_3;														// Package Declared					
import java.io.IOException;													// IOException catch the IOException  method
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Task1Mapper 													// Class declared
	extends Mapper<LongWritable,Text,Text,Text> { 							// class is extended to have the arguments keyIn as LongWritable and ValueIn as Text and KeyOut as Text and ValueOut as Text.
@Override
    public void map(LongWritable key, Text value, Context context) 			// overriding the map method which will run one time for every line.
    		throws IOException, InterruptedException{						// throws for exception handling
	String line=value.toString();											// storing the line in a string variable
    String[] words=line.split("\\|");										// splitting the line by using comma “|” delimiter and storing the values in a String Array so that all the columns in a row are stored in the string array.
    String Company_Name=words[0];											// string array declared with position 0
    String Product_Name=words[1];											// string array declared with position 1
    if (!(Company_Name.equals("NA")|| Product_Name.equals("NA")))			// if loop condition with string array not equal to NA
            context.write(value, new Text());								//  obtaining Text as value to the context.
	}																		// map class closed
}																			// class Task1Mapper closed

