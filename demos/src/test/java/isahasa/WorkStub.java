package isahasa;

public class WorkStub implements Work {

    private boolean called;

    @Override
    public String complete() {
        called = true;
        return null;
    }

    public boolean isCalled() {
        return called;
    }
}
