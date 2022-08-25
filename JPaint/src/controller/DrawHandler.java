package controller;


import ControllerInterfaces.IStartAndEndPointCommand;
import model.ApplicationSettings;
import model.ShapeFactory;
import model.ShapeList;
import ControllerInterfaces.IMouseModeObserver;
import view.DisplayableShapeFactory;
import view.GuiUiModule.PaintCanvas;
import view.GuiViewShapeFactory;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;


public class DrawHandler extends MouseInputAdapter implements IMouseModeObserver {
    private Point drawStart;
    private PaintCanvas canvas;
    private ShapeList shapeList;
    private ApplicationSettings settings;
    private IStartAndEndPointCommand masterCommand;

    public DrawHandler(ApplicationSettings settings, PaintCanvas canvas, ShapeList shapeList){
        this.settings = settings;
        this.canvas = canvas;
        this.shapeList = shapeList;
    }
    @Override
    public void mousePressed(MouseEvent e){
        drawStart = new Point(e.getPoint());
    }
    @Override
    public void mouseReleased(MouseEvent e){
        Point drawEnd = new Point(e.getPoint());
        try {
            masterCommand.run(drawStart, drawEnd);
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    @Override
    public void update(MouseMode mode) {
        switch(mode) {
            case DRAW:
                masterCommand = new CreateShapeCommand(new ShapeFactory(settings, shapeList, new GuiViewShapeFactory(canvas), new DisplayableShapeFactory()), shapeList);
                break;
            case MOVE:
                masterCommand = new MoveShapeCommand(shapeList);
                break;
            case SELECT:
                masterCommand = new ShapeSelectorCommand(shapeList);
                break;
            default:
                masterCommand = new ShapeSelectorCommand(shapeList);
                break;
        }
    }
}