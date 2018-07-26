package controller;

import ControllerInterfaces.IMouseModeObservable;
import ControllerInterfaces.IMouseModeObserver;
import viewInterfaces.IDialogChoice;

public class MouseModeSettings implements IDialogChoice, IMouseModeObservable{
    private MouseMode chosenMode;
    private IMouseModeObserver observer;

    void setChosenMode(MouseMode chosenMode){
        this.chosenMode = chosenMode;
        notifyObserver();
    }

    MouseMode getChosenMode(){ return chosenMode;}


    @Override
    public String getDialogTitle() {
        return "Better pick a mouse mode";
    }

    @Override
    public String getDialogText() {
        return "Pick one. I don't care";
    }

    @Override
    public Object[] getDialogOptions() {
        return MouseMode.values();
    }

    @Override
    public Object getDefaultChoice() {
        return getChosenMode();
    }

    @Override
    public void registerObserver(IMouseModeObserver mouseHandler) {
        this.observer = mouseHandler;
    }

    @Override
    public void notifyObserver() {
        observer.update(chosenMode);
    }
}
