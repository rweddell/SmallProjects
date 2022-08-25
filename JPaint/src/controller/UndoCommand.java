package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import model.CommandHistory;

public class UndoCommand implements ICommand, IUndoable{
    public void run(){
        CommandHistory.undo();
    }

    @Override
    public void undo() {
        CommandHistory.redo();
    }

    @Override
    public void redo() {
        CommandHistory.undo();
    }
}
