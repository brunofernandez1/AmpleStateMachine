package AmpleStateMachine;

import java.math.BigInteger;
import java.util.Random;

public class StartState extends State {


    public StartState(Ampel ampel) {
        super(ampel);
    }

    @Override
    public void handleStart() {
        ampel.setState(this);
        //while (!ampel.getkontaktSchleife() | !ampel.getHasError()) {

                ampel.setGreen();
        System.out.println("green was set");
                //ampel.setYellow();
                //ampel.setRed();
                //ampel.setYellow();
        //}

        if (ampel.getkontaktSchleife()){
            ampel.setState(this);
            ampel.handleStart();
            ampel.setkontaktSchleife(false);
        }

        if (ampel.getHasError()){
            ampel.setState(new ErrorState(ampel));
            ampel.handleError();
        }
    }

    @Override
    public void handleStop() {
        ampel.setState(new IdleState(ampel));

    }

    @Override
    public void handleKontaktschleife() {
        ampel.setState(new StartState(ampel));
    }

    @Override
    public void handleError() {
        ampel.setState(new ErrorState(ampel));
    }
}
