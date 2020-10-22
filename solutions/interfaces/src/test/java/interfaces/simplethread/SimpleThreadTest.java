package interfaces.simplethread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleThreadTest {

	@Test
	public void runWithEmptyTasks() {
		List<String> tasks = new ArrayList<>();
		SimpleThread simpleThread = new SimpleThread(tasks);
		assertThat(simpleThread.getTasks().size(), is(0));

		simpleThread.run();

		assertThat(simpleThread.getTasks().size(), is(0));
	}

	@Test
	public void runWithTasks() {
		List<String> tasks = new ArrayList<>();
		tasks.add("sut");
		tasks.add("foz");
		tasks.add("takarit");
		SimpleThread simpleThread = new SimpleThread(tasks);
		assertThat(simpleThread.getTasks().size(), is(tasks.size()));

		simpleThread.run();

		assertThat(simpleThread.getTasks().size(), is(0));
	}

}