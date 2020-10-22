package longwords;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

public class LongWordService {

    public void writeLongWords(Writer writer, List<String> words){

        PrintWriter printWriter = new PrintWriter(writer);
        for(String s : words){
            printWriter.print(s);
            printWriter.print(":");
            printWriter.println(s.length());
        }
    }


    public String writeWithStringWriter(List<String> words){
        try(StringWriter sw = new StringWriter()){
           writeLongWords(sw,words);
           return sw.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Can't write!",e);
        }
    }

}
