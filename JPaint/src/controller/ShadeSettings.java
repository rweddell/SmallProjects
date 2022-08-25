package controller;

import viewInterfaces.IDialogChoice;

public class ShadeSettings implements IDialogChoice {
    private ShadingType _currentShadingType;

    void setCurrentShadingType(ShadingType currentShadingType){
        _currentShadingType = currentShadingType;
    }

    public ShadingType getCurrentShadingType() { return _currentShadingType;}

    @Override
    public String getDialogTitle() {
        return "Pick a shader, dude";
    }

    @Override
    public String getDialogText() {
        return "One of these. I guess...";
    }

    @Override
    public Object[] getDialogOptions() {
        return ShadingType.values();
    }

    @Override
    public Object getDefaultChoice() {
        return getCurrentShadingType();
    }
}
