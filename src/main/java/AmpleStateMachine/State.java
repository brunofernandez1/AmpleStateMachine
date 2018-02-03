package AmpleStateMachine;

public abstract class State implements EventHandler {
    protected Ampel ampel;
    protected String stateName;

    public State(Ampel ampel, String stateName) {
        this.ampel = ampel;
        this.stateName = stateName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setState(Ampel ampel){
        this.ampel.setState(this);
    }
}
