package controliteration.dictionary;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DictionaryTest {

    @Test
    public void shouldFind() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));

        List<String> translations = dictionary.findTranslations("kutya");
        assertThat(translations, equalTo(Arrays.asList("pooch", "dog")));
    }

    @Test
    public void shouldAppend() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));
        dictionary.addItem("kutya", Collections.singletonList("dawg"));

        List<String> translations = dictionary.findTranslations("kutya");
        assertThat(translations, equalTo(Arrays.asList("pooch", "dog", "dawg")));
    }

    @Test
    public void shouldAppendOnlyOnce() {
        Dictionary dictionary = new Dictionary();
        dictionary.addItem("kutya", Arrays.asList("pooch", "dog"));
        dictionary.addItem("kutya", Collections.singletonList("dawg"));
        dictionary.addItem("kutya", Collections.singletonList("dawg"));

        List<String> translations = dictionary.findTranslations("kutya");
        assertThat(translations, equalTo(Arrays.asList("pooch", "dog", "dawg")));
    }
}
