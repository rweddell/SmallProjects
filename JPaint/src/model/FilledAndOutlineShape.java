package model;

import model.ShapeProperties;
import modelInterfaces.IDisplayableShape;
import viewInterfaces.IViewShape;
import java.awt.*;

public class FilledAndOutlineShape implements IDisplayableShape {
    private final IViewShape viewShape;

    public FilledAndOutlineShape(IViewShape viewShape){
        this.viewShape = viewShape;
    }
    @Override
    public void display() {
        viewShape.displayFilled(viewShape.getPrimaryColor());
        viewShape.displayOutline(viewShape.getSecondaryColor());
    }
    public ShapeProperties getShapeProperties(){
        return viewShape.getShapeProperties();
    }
}
