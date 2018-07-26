package controller;

import ControllerInterfaces.ICommand;
import viewInterfaces.UIModule;

public class SelectShadingCommand implements ICommand {
    private final ShadeSettings shadeSettings;
    private final UIModule uiModule;
    SelectShadingCommand(ShadeSettings shadeSettings, UIModule uiModule){
        this.shadeSettings = shadeSettings;
        this.uiModule = uiModule;
    }
    @Override
    public void run(){
        ShadingType shaderChoice = this.uiModule.getDialogResponse(this.shadeSettings);
        this.shadeSettings.setCurrentShadingType(shaderChoice);
    }
}
