/**
 * 
 */
package Assignment_3;																// Package Declared					
import org.apache.hadoop.conf.Configuration;										// Import the Configuration of system parameters.
import org.apache.hadoop.fs.Path;													// used to Names a file or directory in a AbstractFileSystem for hdfs.
import org.apache.hadoop.io.Text;													// This class stores text using standard UTF8 encoding.
import org.apache.hadoop.mapreduce.Job;												// The job submitter's view of the Job.
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;						// FilterInputFormat is a convenience class that wraps InputFormat.
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;						// FilterOutputFormat is a convenience class that wraps OutputFormat.
/**
 * We have a dataset of sales of different TV sets across different locations.
 * Records look like: Samsung|Optima|14|Madhya Pradesh|132401|14200
 * The fields are arranged like:
 * Company Name|Product Name|Size in inches|State|Pin Code|Price
 * There are some invalid records which contain 'NA' in either Company Name or Product Name.
 * 
 * 1. Write a Map Reduce program to filter out the invalid records. Map only job will fit for this context.
 * 
 * All the comments in the program will be placed on the Right-Hand-Side.
 * @author Sahil Khurana <sahilkhurana369@gmail.com
 */
public class Task1 {																// Class declared
	@SuppressWarnings({ "deprecation" })											// The @SuppressWarnings annotation disables certain compiler warnings. In this case, the warning about deprecated code ("deprecation")
	public static void main(String[] args) throws Exception {						// main method started 
        if(args.length !=2){														// if loop to check whether the right input provided
            System.err.println("Invalid Command");									// Print statement
            System.exit(0);	}														// if input is not right then exit the program       
        Configuration conf = new Configuration();									// Create a configuration object for the job
        Job job = new Job(conf, "Task1");											// create new object named jab
        job.setJarByClass(Task1.class);												// Set a name of the Jar
        job.setJobName("Assignment_3.2_Task1");										// Set a name of the Job
        FileInputFormat.addInputPath(job, new Path(args[0]));						// Set input directories using command line arguments,arg[0] = name of input directory on HDFS 
        FileOutputFormat.setOutputPath(job, new Path(args[1]));						// Set output directories using command line arguments,arg[0] = name of output directory on HDFS 				
        job.setMapperClass(Task1Mapper.class);										// Specify names of Mapper Class
        job.setNumReduceTasks(0);													// Sets reducer tasks to 0		
        job.setOutputKeyClass(Text.class);											// Specify data type of output key
        job.setOutputValueClass(Text.class);										// Specify data type of output value
        job.waitForCompletion(true);												// Submit the job, then poll for progress until the job is complete
     }																				// main method closed
}																					// class Task1 closed
