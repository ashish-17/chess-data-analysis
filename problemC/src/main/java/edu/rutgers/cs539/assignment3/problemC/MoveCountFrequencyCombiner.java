package edu.rutgers.cs539.assignment3.problemC;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MoveCountFrequencyCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		
		int count = 0;
		while (values.iterator().hasNext()) {
			count += values.iterator().next().get();
		}
		
		context.write(key, new IntWritable(count));
	}
}
