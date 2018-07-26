package view.GuiUiModule;

import model.ShapeProperties;
import viewInterfaces.IViewShape;

import java.awt.*;

public class GuiTriangle implements IViewShape {
    private ShapeProperties shape;
    private PaintCanvas canvas;

    public GuiTriangle(ShapeProperties shape, PaintCanvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void displayOutline(Color color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setStroke(new BasicStroke(5));
        graphics.setColor(color);
        int[] xPoints = {shape.getStartX() + ((shape.getEndX() - shape.getStartX()) / 2), shape.getStartX(), shape.getEndX()};
        int[] yPoints = {shape.getStartY(), shape.getEndY(), shape.getEndY()};
        graphics.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void displayFilled(Color color) {
        Graphics2D graphics = canvas.getGraphics2D();
        graphics.setColor(color);
        int[] xPoints = {shape.getStartX() + ((shape.getEndX() - shape.getStartX()) / 2), shape.getStartX(), shape.getEndX()};
        int[] yPoints = {shape.getStartY(), shape.getEndY(), shape.getEndY()};
        graphics.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public Color getPrimaryColor() {
        return shape.getPrimaryColor();
    }

    @Override
    public Color getSecondaryColor() {
        return shape.getSecondaryColor();
    }
    @Override
    public ShapeProperties getShapeProperties() {
        return shape;
    }
}