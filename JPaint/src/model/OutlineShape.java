package model;

import model.ShapeProperties;
import modelInterfaces.IDisplayableShape;
import viewInterfaces.IViewShape;

import java.awt.*;

public class OutlineShape implements IDisplayableShape {
    private final IViewShape viewShape;

    public OutlineShape (IViewShape viewShape){
        this.viewShape = viewShape;
    }
    public void display(){
        viewShape.displayOutline(viewShape.getPrimaryColor());
    }
    public ShapeProperties getShapeProperties(){
        return viewShape.getShapeProperties();
    }
}
