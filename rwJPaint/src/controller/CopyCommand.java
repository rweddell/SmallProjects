package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import model.CommandHistory;
import model.ShapeList;

public class CopyCommand implements ICommand, IUndoable {
    private ShapeList shapeList;
    CopyCommand (ShapeList shapelist){
        this.shapeList = shapeList;
    }
    public void run(){
        CommandHistory.add(this);
    }
    public void undo(){ }
    public void redo(){ }
}
