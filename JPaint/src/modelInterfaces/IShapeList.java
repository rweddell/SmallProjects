package modelInterfaces;

import view.GuiUiModule.PaintCanvas;

import java.awt.*;

public interface IShapeList {
    void registerObserver(PaintCanvas canvas);
    void notifyObservers();
}
