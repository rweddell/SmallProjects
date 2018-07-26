package viewInterfaces;


import model.ShapeProperties;

import java.awt.*;

public interface IViewShape {
    void displayOutline(Color color);
    void displayFilled(Color color);
    Color getPrimaryColor();
    Color getSecondaryColor();
    ShapeProperties getShapeProperties();
}
