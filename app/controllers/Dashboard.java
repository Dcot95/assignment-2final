package controllers;

import java.util.ArrayList;
import java.util.List;

import jdk.internal.net.http.common.Log;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        render("dashboard.html");
    }

}
