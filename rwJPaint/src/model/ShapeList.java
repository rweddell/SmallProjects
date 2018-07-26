package model;

import modelInterfaces.IDisplayableShape;
import modelInterfaces.IShapeList;
import view.GuiUiModule.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ShapeList implements IShapeList {
    private PaintCanvas listener;
    private Stack<IDisplayableShape> shapeList = new Stack<>();
    private ArrayList <IDisplayableShape> selectedList = new ArrayList<>(50);
    private Stack <IDisplayableShape> undoneList = new Stack<>();

    public void registerObserver(PaintCanvas thisCanvas){
        this.listener = thisCanvas;
    }

    public void notifyObservers() {
        listener.update(selectedList);
        listener.update(shapeList);
    }

    void addToList(IDisplayableShape newShape){
        shapeList.add(newShape);
        notifyObservers();
    }
    public void removeShape(){
        if (!shapeList.empty()) {
            IDisplayableShape shape = shapeList.pop();
            undoneList.push(shape);
            notifyObservers();
        }
    }
    public void restoreShape(){
        if (!undoneList.empty()) {
            IDisplayableShape shape = undoneList.pop();
            shapeList.push(shape);
            notifyObservers();
        }
    }

    public void checkShapeListForSelected(Point start, Point end){
        selectedList.clear();
        int selectHt = (int)( end.getY() - start.getY());
        int selectWd = (int) (end.getX() - start.getX());
        int selectX = (int) start.getX();
        int selectY = (int) start.getY();
        ShapeProperties shapeState;
        for (IDisplayableShape shape: shapeList){
            shapeState = shape.getShapeProperties();
            if (shapeState.getStartX() < selectX + selectWd &&
                shapeState.getStartX() + shapeState.getWidth() > selectX &&
                shapeState.getStartY() < selectY + selectHt &&
                shapeState.getHeight() + shapeState.getStartY() > selectY){
                    selectedList.add(shape);
            }
        }
    }
    public void moveSelectedShape(Point moveStart, Point moveEnd){
        ShapeProperties shapeState;
        int xDifference = (int) (moveEnd.getX() - moveStart.getX());
        int yDifference = (int) (moveEnd.getY() - moveStart.getY());
        for(IDisplayableShape shape: selectedList){
            shapeState = shape.getShapeProperties();
            Point updateStart = new Point( (shapeState.getStartX()) + xDifference , shapeState.getStartY() + yDifference);
            Point updateEnd = new Point(shapeState.getWidth() + (int) updateStart.getX(), shapeState.getHeight()+ (int) updateStart.getY());

            shapeState.setNewStartAndEnd(updateStart, updateEnd);
        }
        notifyObservers();
    }
    public void undoMove(int deltaX, int deltaY){
       ShapeProperties shapeState;
       for (IDisplayableShape shape: selectedList){
           shapeState = shape.getShapeProperties();
           Point updateStart = new Point(shapeState.getStartX() - deltaX, shapeState.getStartY() - deltaY);
           Point updateEnd= new Point(shapeState.getEndX() - deltaX, shapeState.getEndY() - deltaY);
           shapeState.setNewStartAndEnd(updateStart, updateEnd);
       }
       notifyObservers();
    }
    public void redoMove (int deltaX, int deltaY){
        ShapeProperties shapeState;
        for (IDisplayableShape shape: selectedList){
            shapeState = shape.getShapeProperties();
            Point updateStart = new Point(shapeState.getStartX() + deltaX, shapeState.getStartY() + deltaY);
            Point updateEnd= new Point(shapeState.getEndX() + deltaX, shapeState.getEndY() + deltaY);
            shapeState.setNewStartAndEnd(updateStart, updateEnd);
        }
        notifyObservers();
    }
    public void copySelected(){
        for (IDisplayableShape shape : selectedList){
            shapeList.add(shape);
            shape.getShapeProperties().setNewStartPoint(new Point( 10,10));
        }
    }
    public void deleteSelected(){
        for(Iterator<IDisplayableShape> iterator = selectedList.iterator(); iterator.hasNext();){
            IDisplayableShape shape = iterator.next();
            if (shapeList.contains(shape)){
                    undoneList.push(shape);
                    shapeList.remove(shape);
            }
            notifyObservers();
        }
    }
}
