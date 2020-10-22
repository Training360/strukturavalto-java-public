package interfaces.simplethread;

import java.util.List;

public class SimpleThread implements Runnable {
	private List<String> tasks;

	public SimpleThread(List<String> tasks) {
		this.tasks = tasks;
	}

	private void nextStep() {
		if (tasks != null && !tasks.isEmpty()) {
			tasks.remove(tasks.size() - 1);
		}
	}

	@Override
	public void run() {
		while(!tasks.isEmpty()) {
			nextStep();
		}
	}

	public List<String> getTasks() {
		return tasks;
	}
}
