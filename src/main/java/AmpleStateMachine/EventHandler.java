package AmpleStateMachine;

public interface EventHandler {
    public void handleStart();
    public void handleStop();
    public void handleKontaktschleife();
    public void handleError();
}
