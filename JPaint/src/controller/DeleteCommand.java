package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import model.CommandHistory;
import model.ShapeList;


public class DeleteCommand implements ICommand, IUndoable {
    private ShapeList shapeList;
    DeleteCommand (ShapeList masterlist){
        this.shapeList = masterlist;
    }
    public void run(){
        CommandHistory.add(this);
        shapeList.deleteSelected();
    }
    public void undo(){
        shapeList.restoreShape();
    }
    public void redo(){
        shapeList.deleteSelected();
    }
}
