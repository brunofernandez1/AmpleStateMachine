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
    Boolean kontaktSchleife = false;
    Boolean hasError = false;


    public Ampel(){



        state = new IdleState(this);
        this.ampel = this;
        VerticalLayout panelContent = new VerticalLayout();
        red = new Button("red");
        yellow = new Button("yellow");
        green = new Button("green");
        Button start = new Button("start");
        Button stop = new Button("stop");
        Button error = new Button("generate error");
        Button kontaktSchleifebtn = new Button("Kontaktschleife error");

        stop.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                ampel.handleStop();
                System.out.println("test");
            }

        });
        start.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                ampel.handleStart();
            }
        });
        error.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ampel.handleError();
            }
        });

        kontaktSchleifebtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (kontaktSchleife){
                    ampel.setkontaktSchleife(false);
                }
                else {
                    ampel.setkontaktSchleife(true);

                }
            }
        });

        panelContent.addComponents(red, yellow, green, start, stop, error, kontaktSchleifebtn);
        setCompositionRoot(panelContent);

        // Set the size as undefined at all levels
        panelContent.setSizeUndefined();

    }


    public void setState(State state) {
        this.state = state;

    }

    @Override
    public void handleStart() {

            this.state.handleStart();


    }

    @Override
    public void handleStop() {
        this.state.handleStop();

    }

    @Override
    public void handleKontaktschleife() {
        this.state.handleStart();
    }

    @Override
    public void handleError() {
        this.state.handleError();

    }

    public State getStateOfAmpel(){
        return this.state;
    }

    public void setGreen(){

        this.green.removeStyleName("status-stopped");
        this.green.addStyleName("status-running-green");

        this.red.removeStyleName("status-running-red");
        this.red.addStyleName("status-stopped");

        this.yellow.removeStyleName("status-running-yellow");
        this.yellow.addStyleName("status-stopped");



    }

    public void setRed(){
        this.green.removeStyleName("status-running-green");
        this.green.addStyleName("status-stopped");

        this.red.removeStyleName("status-stopped");
        this.red.addStyleName("status-running-red");

        this.yellow.removeStyleName("status-running-yellow");
        this.yellow.addStyleName("status-stopped");


    }

    public void setYellow(){
        this.green.removeStyleName("status-running-green");
        this.green.addStyleName("status-stopped");

        this.red.removeStyleName("status-running-red");
        this.red.addStyleName("status-stopped");

        this.yellow.removeStyleName("status-stopped");
        this.yellow.addStyleName("status-running-yellow");
    }

    public void setBlank(){
        this.yellow.removeStyleName("status-running-yellow");
        this.red.removeStyleName("status-running-red");
        this.green.removeStyleName("status-running-green");

        this.green.addStyleName("status-stopped");
        this.red.addStyleName("status-stopped");
        this.yellow.addStyleName("status-stopped");
    }

    public void setkontaktSchleife(Boolean typ){
        ampel.kontaktSchleife = typ;
    }

    public boolean getkontaktSchleife(){
        return this.kontaktSchleife;
    }

    public boolean getHasError(){
        return this.hasError;
    }

    public void setHasError(Boolean typ){
        this.hasError = typ;
    }

}




