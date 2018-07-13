package controller;

import viewInterfaces.IDialogChoice;

class ApplicationSettings {
    private ShapeSettings drawShapeSettings = new ShapeSettings();

    ShapeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
}
