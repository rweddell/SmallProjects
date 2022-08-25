package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import model.CommandHistory;
import model.ShapeList;

public class PasteCommand implements ICommand, IUndoable {
    private ShapeList shapeList;
    PasteCommand(ShapeList shapeList){
        this.shapeList = shapeList;
    }
    public void run(){
        CommandHistory.add(this);
    }
    public void undo(){
        //TODO: make undo/redo paste in shapelist
        //shapeList.pasteShapes
    }
    public void redo(){}

}
