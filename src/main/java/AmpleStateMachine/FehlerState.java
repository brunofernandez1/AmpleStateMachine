package AmpleStateMachine;

public class FehlerState extends State {


    public FehlerState(EventHandlerImpl ampel, String stateName) {
        super(ampel, stateName);
    }

    @Override
    public void handleKontaktschleife() {

    }

    @Override
    public void handleFehler() {

    }
}
