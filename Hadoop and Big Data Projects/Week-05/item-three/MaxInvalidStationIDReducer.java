// cc MaxTemperatureReducer Reducer for maximum temperature example
// vv MaxTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.*;
import java.text.DecimalFormat;

public class MaxInvalidStationIDReducer
  extends Reducer<Text, IntWritable, Text, IntWritable> {

  private int cnt =0;
  private Text stamp = new Text("");
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
                     Context context)
      throws IOException, InterruptedException {

    int count = 0;

       for (IntWritable value : values) {

          if (value.get() == 9999){
             count++;
          }
        }

      if (count >cnt) {
           cnt = count;
           stamp = key;
      }
   }

@Override
public void cleanup(Context context)
    throws IOException, InterruptedException {

   context.write(sta, new IntWritable(cnt));
  }
}






// ^^ MaxTemperatureReducer