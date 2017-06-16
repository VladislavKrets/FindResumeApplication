package com.findresume.app;

import java.io.IOException;

/**
 * Created by lollipop on 16.06.2017.
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        model.getVacancies();
    }
}
