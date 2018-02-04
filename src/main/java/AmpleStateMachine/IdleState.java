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
        super.ampel.setState(new IdleState(ampel));
    }

    @Override
    public void handleKontaktschleife() {
        //do nothing here
    }

    @Override
    public void handleError() {
        super.ampel.setState(new ErrorState(ampel));
    }
}
