package model;

import model.ShapeProperties;
import modelInterfaces.IDisplayableShape;
import viewInterfaces.IViewShape;

import java.awt.*;

public class FilledShape implements IDisplayableShape {
    private final IViewShape viewShape;

    public FilledShape (IViewShape viewShape){
        this.viewShape = viewShape;
    }
    @Override
    public void display() {
        viewShape.displayFilled(viewShape.getPrimaryColor());
    }
    public ShapeProperties getShapeProperties(){
        return viewShape.getShapeProperties();
    }
}
