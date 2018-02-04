package AmpleStateMachine;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

public class Ampel extends CustomComponent implements EventHandler {

    State state;
    Ampel ampel;
    Button red;
    Button yellow;
    Button green;

    public Ampel(){
        state = new IdleState(this);
        this.ampel = this;
        VerticalLayout panelContent = new VerticalLayout();
        red = new Button("red");
        yellow = new Button("yellow");
        green = new Button("green");
        Button start = new Button("start");
        Button stop = new Button("stop");
        //to show witch is enabled
        red.setEnabled(false);
        yellow.setEnabled(false);
        green.setEnabled(false);
        stop.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                ampel.handleStop();
            }
        });
        start.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                ampel.handleStart();
            }
        });

        panelContent.addComponents(red, yellow, green, start, stop);
        setCompositionRoot(panelContent);

        // Set the size as undefined at all levels
        panelContent.setSizeUndefined();

    }


    public void setState(State state) {
        this.state = state;

    }

    @Override
    public void handleStart() {
        try{
            this.state.handleStart();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void handleStop() {

    }

    public void setGreen(){

        this.green.setEnabled(true);
        this.red.setEnabled(false);
        this.yellow.setEnabled(false);


    }

    public void setRed(){
        this.red.setEnabled(true);
        this.green.setEnabled(false);
        this.yellow.setEnabled(false);


    }

    public void setYellow(){
        this.yellow.setEnabled(true);
        this.red.setEnabled(false);
        this.green.setEnabled(false);
    }

}




