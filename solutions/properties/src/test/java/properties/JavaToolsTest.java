package properties;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JavaToolsTest {

   JavaTools javaTools=new JavaTools();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getToolKeysTest(){
        assertThat(javaTools.getToolKeys(), equalTo(new HashSet<>(Arrays.asList("maven", "junit", "jdk"))));
    }

    @Test
    public void getToolsTest(){
        assertThat(javaTools.getTools(), equalTo(new HashSet<>(Arrays.asList("Apache Maven", "Java Development Kit", "JUnit"))));
    }

    @Test
    public void getNameTest(){
        assertThat(javaTools.getName("junit"),equalTo("JUnit"));
        assertThat(javaTools.getName("jdk"),equalTo("Java Development Kit"));

    }

    @Test
    public void getUrlTest(){
        assertThat(javaTools.getUrl("junit"),equalTo("http://junit.org/junit4/"));
        assertThat(javaTools.getUrl("jdk"),equalTo("http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html"));

    }



}