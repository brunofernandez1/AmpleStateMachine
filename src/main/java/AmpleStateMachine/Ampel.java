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

        /////temp
        green.addStyleName("status-running");
        red.addStyleName("status-stopped");
        yellow.addStyleName("status-stopped");
        start.addStyleName("status-stopped");
        stop.addStyleName("status-stopped");
        /////temp

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

        this.green.addStyleName("status-running");
        this.red.addStyleName("status-stopped");
        this.yellow.addStyleName("status-stopped");



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

    public void setBlank(){
        this.yellow.setEnabled(false);
        this.red.setEnabled(false);
        this.green.setEnabled(false);
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




