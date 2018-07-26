package viewInterfaces;

import modelInterfaces.IDisplayableShape;
import view.GuiUiModule.PaintCanvas;

import java.awt.*;
import java.util.List;
import java.util.Observer;

public interface IShapeListObserver {
    void update(List<IDisplayableShape> shapes);
}
