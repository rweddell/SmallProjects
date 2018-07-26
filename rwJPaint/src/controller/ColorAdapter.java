package controller;


import java.awt.*;

public class ColorAdapter {
    private Color realColor;

    public ColorAdapter(ColorChoice colorChoice) {
        switch (colorChoice) {
            case BLACK:
                realColor = Color.BLACK;
                break;
            case RED:
                realColor = Color.RED;
                break;
            case BLUE:
                realColor = Color.BLUE;
                break;
            case GREEN:
                realColor = Color.GREEN;
                break;
            case WHITE:
                realColor = Color.WHITE;
                break;
            default:
            realColor = Color.BLACK;
        }
    }
    public Color getColor(){
        return realColor;
    }
}
