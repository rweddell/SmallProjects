package controller;

import ControllerInterfaces.ICommand;
import viewInterfaces.UIModule;

public class SelectColorCommand implements ICommand {
    private final ColorSettings _colorSettings;
    private final UIModule _uiModule;

    SelectColorCommand(ColorSettings colorSettings, UIModule uiModule) {
        _colorSettings = colorSettings;
        _uiModule = uiModule;
    }

    @Override
    public void run() {
        ColorChoice colorChoice = _uiModule.getDialogResponse(_colorSettings);
        _colorSettings.setCurrentColor(colorChoice);
    }

}
