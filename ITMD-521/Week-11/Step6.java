import java.io.IOException;

import com.cloudera.sqoop.lib.RecordParser.ParseError;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.*;
import java.math.BigDecimal;
import java.util.*;


public class Mode extends Configured implements Tool {

  public static class ModeMapper
      extends Mapper<LongWritable, Text, Text, IntWritable> {


    public void map(LongWritable k, Text v, Context context)throws IOException, InterruptedException {
      Widget widgets = new Widget();
      try {
        widgets.parse(v); // Auto-generated: parse all fields from text.
      } catch (ParseError pe) {
        // Got a malformed record. Ignore it.
        return;
      }

      String widget = widgets.get_widget_name();
      IntWritable one = new IntWritable(1);
     context.write(new Text(widget),one);
    }
  }

  public static class ModeReducer
      extends Reducer<Text, IntWritable, Text, IntWritable> {

    // There will be a single reduce call with key '0' which gets
    // the max widget from each map task. Pick the max widget from
    // this list.
    public void reduce(Text k, Iterable<IntWritable> vals, Context context)
        throws IOException, InterruptedException {int mValue = 0;
        int mCount = 0;
        if (mCount <1){
         try{

      for (IntWritable value : vals){
      mCount++;
             }

        if(mCount > mValue) {
            mValue = mCount;
}
             context.write(k, new IntWritable(mValue));
    } catch(Exception e) {
   }
 }
 }
}

  public int run(String [] args) throws Exception {
    Job job = new Job(getConf());

    job.setJarByClass(Mode.class);

    job.setMapperClass(ModeMapper.class);
    job.setReducerClass(ModeReducer.class);

    FileInputFormat.addInputPath(job, new Path("widgets"));
    FileOutputFormat.setOutputPath(job, new Path("avgprice"));

    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    job.setNumReduceTasks(1);

    if (!job.waitForCompletion(true)) {
      return 1; // error.
    }

    return 0;
  }

  public static void main(String [] args) throws Exception {
    int ret = ToolRunner.run(new Mode(), args);
    System.exit(ret);
  }
}