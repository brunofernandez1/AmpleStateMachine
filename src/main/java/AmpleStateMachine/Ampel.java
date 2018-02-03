package AmpleStateMachine;

public class Ampel implements EventHandler {

    State state;

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void handleStart() {
        this.state.handleStart();
    }

    @Override
    public void handleStop() {

    }
}


