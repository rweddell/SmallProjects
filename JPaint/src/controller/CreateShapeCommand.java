package controller;

import ControllerInterfaces.IStartAndEndPointCommand;
import ControllerInterfaces.IUndoable;
import model.CommandHistory;
import model.ShapeList;
import modelInterfaces.IShapeFactory;

import java.awt.*;

public class CreateShapeCommand implements IStartAndEndPointCommand, IUndoable{
    private final IShapeFactory shapeFactory;
    private final ShapeList masterList;

    CreateShapeCommand(IShapeFactory shapeFactory, ShapeList masterList){
        this.shapeFactory = shapeFactory;
        this.masterList = masterList;
    }

    @Override
    public void run(Point drawStart, Point drawEnd) throws Exception{
        shapeFactory.create(drawStart, drawEnd);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        masterList.removeShape();
    }

    @Override
    public void redo() {
        masterList.restoreShape();
    }
}
