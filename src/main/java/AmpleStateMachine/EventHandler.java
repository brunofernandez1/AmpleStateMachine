package AmpleStateMachine;

public interface EventHandler {
    public void handleStart() throws InterruptedException;
    public void handleStop();
}
