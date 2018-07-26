package controller;

import ControllerInterfaces.IStartAndEndPointCommand;
import model.ApplicationSettings;
import model.ShapeList;

import java.awt.*;

public class ShapeSelectorCommand implements IStartAndEndPointCommand {

    private ShapeList shapelist;

    ShapeSelectorCommand( ShapeList masterList){
        this.shapelist = masterList;
    }
    @Override
    public void run(Point drawStart, Point drawEnd) throws Exception {
        shapelist.checkShapeListForSelected(drawStart, drawEnd);
    }

}
