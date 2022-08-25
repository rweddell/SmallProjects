package view.GuiUiModule;

import model.ShapeProperties;
import viewInterfaces.IViewShape;
import java.awt.Graphics2D;

import java.awt.*;


public class GuiEllipse implements IViewShape {
    private ShapeProperties shape;
    private PaintCanvas canvas;

    public GuiEllipse(ShapeProperties shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void displayOutline(Color color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(color);
        graphics.drawOval(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());
    }

    @Override
    public void displayFilled(Color color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setColor(color);
        graphics.fillOval(shape.getStartX(), shape.getStartY(), shape.getWidth(), shape.getHeight());
    }

    @Override
    public Color getPrimaryColor() {
        return shape.getPrimaryColor();
    }

    @Override
    public Color getSecondaryColor() { return shape.getSecondaryColor(); }
    @Override
    public ShapeProperties getShapeProperties() {
        return shape;
    }
}
