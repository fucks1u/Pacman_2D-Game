package src.main;

import src.main.mvc.model.item.BigDotModel;
import src.main.mvc.view.frames.MenuFrame;

public class Main {
    public static void main(String[] args) {
        new MenuFrame();
        BigDotModel bigDot = new BigDotModel();
        bigDot.setVulnerability();
    }
}
