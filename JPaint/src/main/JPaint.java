package main;

import ControllerInterfaces.IPaintController;

class JPaint {
    private IPaintController _controller;

    JPaint(IPaintController controller) {
        _controller = controller;
    }

    void run() {
        _controller.run();
    }
}
