package AmpleStateMachine;

public class IdleState extends State {

    public IdleState(Ampel ampel) {
        super(ampel);
    }

    @Override
    public void handleStart() {
        super.ampel.setState(new StartState(super.ampel));
        super.ampel.handleStart();
    }

    @Override
    public void handleStop() {

    }
}
