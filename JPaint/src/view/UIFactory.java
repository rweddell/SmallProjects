package view;

import model.ApplicationSettings;
import controller.DrawHandler;
import model.ShapeList;
import ControllerInterfaces.IMouseModeObserver;
import view.CmdUiModule.Cmd;
import view.GuiUiModule.Gui;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.InvalidUIException;
import viewInterfaces.UIModule;
import view.GuiUiModule.GuiWindow;

import java.awt.event.MouseListener;

public class UIFactory {
    public static UIModule createUI(UIType uiType, ApplicationSettings settings, ShapeList shapeList) throws InvalidUIException {
        UIModule ui;

        switch(uiType){
            case CMD:
                ui = new Cmd();
                break;
            case GUI:
                PaintCanvas canvas = new PaintCanvas();
                ui = new Gui(new GuiWindow (canvas));
                MouseListener mouseListener = new DrawHandler(settings, canvas, shapeList);
                canvas.addMouseListener(mouseListener);
                shapeList.registerObserver(canvas);
                settings.getChosenModeSettings().registerObserver((IMouseModeObserver) mouseListener);
                break;
            default:
                throw new InvalidUIException();
        }
        return ui;

    }
}
