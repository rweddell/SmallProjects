package controller;

import viewInterfaces.IDialogChoice;

public class ColorSettings implements IDialogChoice {
    private ColorChoice _currentColorChoice;

    void setCurrentColor( ColorChoice currentColorChoice) {
        _currentColorChoice = currentColorChoice;
    }

    public ColorChoice getCurrentColor(){return _currentColorChoice;}

    @Override
    public String getDialogTitle() {
        return "Pick a color, dude";
    }

    @Override
    public String getDialogText() {
        return "One o' these:";
    }

    @Override
    public Object[] getDialogOptions() {
        return ColorChoice.values();
    }
    @Override
    public Object getDefaultChoice() {
        return getCurrentColor();
    }
}
