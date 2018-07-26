package controller;

import ControllerInterfaces.ICommand;
import ControllerInterfaces.IUndoable;
import model.CommandHistory;

public class RedoCommand implements ICommand, IUndoable {
    public void run(){
        CommandHistory.redo();
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
