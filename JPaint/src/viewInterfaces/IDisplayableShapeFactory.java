package viewInterfaces;

import controller.ShadingType;
import modelInterfaces.IDisplayableShape;
import viewInterfaces.IViewShape;

public interface IDisplayableShapeFactory {
    IDisplayableShape createDisplayShape(ShadingType currentShading, IViewShape viewShape) throws Exception;
}
