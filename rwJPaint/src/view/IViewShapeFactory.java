package view;

import controller.ShapeChoices;
import model.ShapeProperties;
import viewInterfaces.IViewShape;

public interface IViewShapeFactory {
    IViewShape createViewShape(ShapeChoices currentShapeChoices, ShapeProperties newShape) throws Exception;
}
