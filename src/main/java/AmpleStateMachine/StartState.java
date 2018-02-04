package AmpleStateMachine;

import java.math.BigInteger;
import java.util.Random;

public class StartState extends State {


    public StartState(Ampel ampel) {
        super(ampel);
    }

    @Override
    synchronized
    public void handleStart() {
        ampel.setState(this);

        while (!ampel.getkontaktSchleife() | !ampel.getHasError()) {

                ampel.setGreen();
                System.out.println("green was set");
                try{Thread.sleep(5000);}
                catch (Exception e){}
                ampel.setYellow();
                System.out.println("yellow was set");
                try{Thread.sleep(5000);}
                catch (Exception e){}
                ampel.setRed();
                System.out.println("red was set");
                try{Thread.sleep(5000);}
                catch (Exception e){}
                ampel.setYellow();
                System.out.println("yellow was set");
        }

        if (ampel.getkontaktSchleife()){
            System.out.println("kontaktschleife running");
            ampel.setState(this);
            ampel.handleStart();
            ampel.setkontaktSchleife(false);
        }

        if (ampel.getHasError()){
            System.out.println("handling error");
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
