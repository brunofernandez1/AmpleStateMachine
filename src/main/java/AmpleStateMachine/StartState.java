package AmpleStateMachine;

public class StartState extends State {


    public StartState(Ampel ampel, String stateName) {
        super(ampel, stateName);
    }

    @Override
    public void handleStart() {
        ampel.setState(this);
    }

    @Override
    public void handleStop() {

    }
}
