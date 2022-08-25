package model;

import java.awt.*;

public class ShapeProperties {
    private Color primaryColor;
    private Color secondaryColor;
    private Point drawStart;
    private Point drawEnd;


    ShapeProperties(Color primaryColor, Color secondaryColor, Point drawStart, Point drawEnd){
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.drawStart = drawStart;
        this.drawEnd = drawEnd;
    }
    void setNewStartAndEnd(Point newStart, Point newEnd){
        this.drawStart = newStart;
        this.drawEnd = newEnd;
    }
    void setNewStartPoint(Point newStart){
        drawEnd = new Point((int)newStart.getX() + getWidth(), (int) newStart.getY() + getWidth());
        this.drawStart = newStart;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }
    public Color getSecondaryColor() {
        return secondaryColor;
    }


    public int getStartX(){
        return (int) drawStart.getX();
    }
    public int getStartY(){
        return (int) drawStart.getY();
    }
    public int getEndY(){
        return (int) drawEnd.getY();
    }
    public int getEndX(){
        return (int) drawEnd.getX();
    }
    public int getWidth(){ return (int) (drawEnd.getX() - drawStart.getX()); }
    public int getHeight(){
        return (int) (drawEnd.getY() - drawStart.getY());
    }
}
