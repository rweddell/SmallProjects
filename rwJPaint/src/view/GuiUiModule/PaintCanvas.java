package view.GuiUiModule;

import modelInterfaces.IDisplayableShape;
import viewInterfaces.IShapeListObserver;

import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JComponent;


public class PaintCanvas extends JComponent implements IShapeListObserver{
    @Override
    public void update(List<IDisplayableShape> shapes){ ;
        getGraphics2D().clearRect(0,0,10000,10000);
        for (IDisplayableShape shape : shapes) {
            shape.display();
        }
    }
    Graphics2D getGraphics2D(){
        return (Graphics2D)getGraphics();
    }
}
