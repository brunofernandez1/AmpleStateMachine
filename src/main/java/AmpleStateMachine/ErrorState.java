package AmpleStateMachine;

public class ErrorState extends State {


    public ErrorState(Ampel ampel) {
        super(ampel);
    }


    @Override
    public void handleStart() {
        ampel.setState(new StartState(ampel));
    }

    @Override
    public void handleStop() {

    }

    @Override
    public void handleKontaktschleife() {

    }

    @Override
    public void handleError() {
        System.out.println("we are having trouble");
        //ampel.setState(new IdleState(ampel));
        ampel.setYellow();
    }
}
