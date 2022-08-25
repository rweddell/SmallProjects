package controller;

import ControllerInterfaces.IPaintController;
import model.ApplicationSettings;
import model.ShapeList;
import viewInterfaces.EventName;
import viewInterfaces.UIModule;

public class JPaintController implements IPaintController {
    private final UIModule _uiModule;
    private final ApplicationSettings _settings;
    private final ShapeList _shapeList;

    public JPaintController(UIModule uiModule, ApplicationSettings settings, ShapeList shapeList){
        _settings = settings;
        _uiModule = uiModule;
        _shapeList = shapeList;
        _settings.getDrawShapeSettings().setCurrentShapeChoices(ShapeChoices.ELLIPSE);
        _settings.getPrimaryColorSettings().setCurrentColor(ColorChoice.BLACK);
        _settings.getSecondaryColorSettings().setCurrentColor(ColorChoice.RED);
        _settings.getShaderSettings().setCurrentShadingType(ShadingType.OUTLINE);
        _settings.getChosenModeSettings().setChosenMode(MouseMode.DRAW);

    }

    @Override
    public void run() {
        _uiModule.addEvent(EventName.CHOOSE_SHAPE, new SelectShapeCommand(_settings.getDrawShapeSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, new SelectColorCommand(_settings.getPrimaryColorSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, new SelectColorCommand(_settings.getSecondaryColorSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, new SelectShadingCommand(_settings.getShaderSettings(), _uiModule));
        _uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, new SelectMouseModeCommand(_settings.getChosenModeSettings(), _uiModule));
        _uiModule.addEvent(EventName.UNDO, new UndoCommand());
        _uiModule.addEvent(EventName.REDO, new RedoCommand());
        _uiModule.addEvent(EventName.COPY, new CopyCommand(_shapeList));
        _uiModule.addEvent(EventName.PASTE, new PasteCommand(_shapeList));
        _uiModule.addEvent(EventName.DELETE, new DeleteCommand(_shapeList));
    }
}
