package ControllerInterfaces;


public interface IMouseModeObservable {
    void registerObserver(IMouseModeObserver mouseHandler);
    void notifyObserver();
}
