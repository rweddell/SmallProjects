package model;

import controller.ColorSettings;
import controller.MouseModeSettings;
import controller.ShadeSettings;
import controller.ShapeSettings;

public class ApplicationSettings {
    private ShapeSettings drawShapeSettings = new ShapeSettings();
    private ColorSettings primaryColorSettings = new ColorSettings();
    private ColorSettings secondaryColorSettings = new ColorSettings();
    private ShadeSettings shaderSettings = new ShadeSettings();
    private MouseModeSettings chosenModeSettings = new MouseModeSettings();

    public ShapeSettings getDrawShapeSettings() {
        return drawShapeSettings;
    }
    public ColorSettings getPrimaryColorSettings() {
        return primaryColorSettings;
    }
    public ColorSettings getSecondaryColorSettings() {
        return secondaryColorSettings;
    }
    public ShadeSettings getShaderSettings() { return shaderSettings; }
    public MouseModeSettings getChosenModeSettings() {
        return chosenModeSettings;
    }

}
