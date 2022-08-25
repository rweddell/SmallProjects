package main;

import ControllerInterfaces.IPaintController;
import model.ApplicationSettings;
import controller.JPaintController;
import model.ShapeList;
import view.UIFactory;
import view.UIType;
import viewInterfaces.UIModule;

public class Main {

	public static void main(String[] args) {

        try {
            ApplicationSettings settings = new ApplicationSettings();
            ShapeList shapeList = new ShapeList();
            UIModule ui = UIFactory.createUI(UIType.GUI, settings, shapeList);
            IPaintController controller = new JPaintController(ui, settings, shapeList);
            JPaint jpaintProgram = new JPaint(controller);
            jpaintProgram.run();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
        }
	}
}
