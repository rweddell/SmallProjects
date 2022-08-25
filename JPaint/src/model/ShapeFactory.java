package model;


import controller.*;
import controller.ShapeChoices;
import modelInterfaces.*;
import view.IViewShapeFactory;
import viewInterfaces.IDisplayableShapeFactory;
import viewInterfaces.IViewShape;

import java.awt.*;

public class ShapeFactory implements IShapeFactory{
    private final ApplicationSettings settings;
    private final ShapeList shapeList;
    private final IViewShapeFactory viewShapeFactory;
    private final IDisplayableShapeFactory displayableShapeFactory;

    public ShapeFactory(ApplicationSettings settings, ShapeList shapeList, IViewShapeFactory viewShapeFactory, IDisplayableShapeFactory displayableShapeFactory){
        this.settings = settings;
        this.shapeList = shapeList;
        this.viewShapeFactory = viewShapeFactory;
        this.displayableShapeFactory = displayableShapeFactory;
    }
    @Override
    public void create(Point drawStart, Point drawEnd) throws Exception{
    Point adjStart = getAdjustedStartingPoint(drawStart, drawEnd);
    Point adjEnd = getAdjustedEndingPoint(drawStart, drawEnd);
    IViewShape viewShape = getIViewShape(adjStart, adjEnd);
    IDisplayableShape displayableShape = getIDisplayableShape(viewShape);
    shapeList.addToList(displayableShape);
    }
    private Point getAdjustedStartingPoint(Point start, Point end){
        int startingX = (int) Math.min(start.getX(), end.getX());
        int startingY = (int) Math.min(start.getY(), end.getY());
        return new Point(startingX, startingY);
    }
    private Point getAdjustedEndingPoint(Point start, Point end){
        int endingX = (int) Math.max(start.getX(), end.getX());
        int endingY = (int) Math.max(start.getY(), end.getY());
        return new Point(endingX, endingY);
    }
    private IViewShape getIViewShape(Point start, Point end) throws Exception{
        ShapeChoices currentShapeChoices = settings.getDrawShapeSettings().getCurrentShapeChoices();
        ShapeProperties newShape = createShape(start, end);
        return viewShapeFactory.createViewShape(currentShapeChoices, newShape);
    }
    private IDisplayableShape getIDisplayableShape(IViewShape viewShape) throws Exception{
        ShadingType chosenShade = settings.getShaderSettings().getCurrentShadingType();
        return displayableShapeFactory.createDisplayShape(chosenShade, viewShape);
    }
    private ShapeProperties createShape(Point start, Point end){
        ColorAdapter primary = new ColorAdapter(settings.getPrimaryColorSettings().getCurrentColor());
        ColorAdapter secondary = new ColorAdapter(settings.getSecondaryColorSettings().getCurrentColor());
        return new ShapeProperties(primary.getColor(), secondary.getColor(), start, end);
    }
}
