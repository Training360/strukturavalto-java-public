package thirdparty;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class WordCounter {

    public int numberOfWords(String s) {
        return Splitter.on(CharMatcher.anyOf(" ,."))
                .trimResults()
                .omitEmptyStrings()
                .splitToList(s).size();
    }
}
