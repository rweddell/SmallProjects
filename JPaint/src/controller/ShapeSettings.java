package controller;

import viewInterfaces.IDialogChoice;

public class ShapeSettings implements IDialogChoice {
    private ShapeChoices currentShapeChoices;

    void setCurrentShapeChoices(ShapeChoices currentShapeChoices) {
        this.currentShapeChoices = currentShapeChoices;
    }

    public ShapeChoices getCurrentShapeChoices() {
        return currentShapeChoices;
    }

    @Override
    public String getDialogTitle() {
        return "Select a ShapeChoices";
    }

    @Override
    public String getDialogText() {
        return "Select a ShapeChoices:";
    }

    @Override
    public Object[] getDialogOptions() {
        return ShapeChoices.values();
    }

    @Override
    public Object getDefaultChoice() {
        return getCurrentShapeChoices();
    }
}
