package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller {
    public static void index(Long id) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);

        Reading latestReading = null;
        if (station.readings.size() > 0) {
            latestReading = station.readings.get(station.readings.size() - 1);
        }

        render("station.html", station, latestReading);
    }


}