package view;

import controller.ShapeChoices;
import model.ShapeProperties;
import view.GuiUiModule.GuiEllipse;
import view.GuiUiModule.GuiRectangle;
import view.GuiUiModule.GuiTriangle;
import view.GuiUiModule.PaintCanvas;
import viewInterfaces.IViewShape;

public class GuiViewShapeFactory  implements IViewShapeFactory{
    private final PaintCanvas canvas;

    public GuiViewShapeFactory(PaintCanvas canvas){
        this.canvas = canvas;
    }
    @Override
    public IViewShape createViewShape(ShapeChoices currentShapeChoices, ShapeProperties shape) throws Exception{
        switch(currentShapeChoices){
            case ELLIPSE:
                return new GuiEllipse(shape, canvas);
            case RECTANGLE:
                return new GuiRectangle(shape, canvas);
            case TRIANGLE:
                return new GuiTriangle(shape, canvas);
            default:
                throw new Exception("Wrong kinda ViewShape. How'd you even do that?");
        }
    }
}
