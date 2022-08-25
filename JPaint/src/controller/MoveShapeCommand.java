package controller;

import ControllerInterfaces.IStartAndEndPointCommand;
import ControllerInterfaces.IUndoable;
import model.CommandHistory;
import model.ShapeList;
import modelInterfaces.IDisplayableShape;

import java.awt.*;
import java.util.Stack;

public class MoveShapeCommand implements IStartAndEndPointCommand, IUndoable {
    private ShapeList shapeList;
    private Stack <Integer> undoXStack = new Stack<>();
    private Stack <Integer> undoYStack = new Stack<>();
    private Stack <Integer> redoXStack = new Stack<>();
    private Stack <Integer> redoYStack = new Stack<>();

    MoveShapeCommand ( ShapeList masterList){
        this.shapeList = masterList;
    }

    @Override
    public void run(Point drawStart, Point drawEnd) throws Exception {
        shapeList.moveSelectedShape(drawStart, drawEnd);
        int deltaX = (int) (drawEnd.getX() - drawStart.getX());
        int deltaY = (int) (drawEnd.getY() - drawStart.getY());
        undoXStack.push(deltaX);
        undoYStack.push(deltaY);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        int oldX = undoXStack.pop();
        redoXStack.push(oldX);
        int oldY = undoYStack.pop();
        redoYStack.push(oldY);
        shapeList.undoMove(oldX, oldY);
    }

    @Override
    public void redo() {
        int oldX = redoXStack.pop();
        undoXStack.push(oldX);
        int oldY = redoYStack.pop();
        undoYStack.push(oldY);
        shapeList.redoMove(oldX, oldY);
    }
}
