package AmpleStateMachine;

public abstract class State implements EventHandler {
    protected Ampel ampel;

    public State(Ampel ampel) {
        this.ampel = ampel;
    }

    public void setState(Ampel ampel){
        this.ampel.setState(this);
    }
}
