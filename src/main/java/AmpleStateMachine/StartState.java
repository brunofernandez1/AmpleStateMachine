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
        try{
            for (int i=0; i<20; i++){
                ampel.setGreen();

                ampel.setYellow();

                ampel.setRed();

                ampel.setYellow();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void handleStop() {

    }
}
