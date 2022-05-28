package models;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public double temperature;
    public double windSpeed;
    public int windDirection;
    public int pressure;


    public Reading(int code, double temperature, double windSpeed, int windDirection, int pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        if ((windDirection >= 0) && (windDirection <= 360)) {
            this.windDirection = windDirection;
        } else {
            this.windDirection = 0;
        }
        this.pressure = pressure;
    }

    public String weatherCode() {
        if (this.code == 100) {
            return "Clear";
        } else if (this.code == 200) {
            return "Partial Clouds";
        } else if (this.code == 300) {
            return "Cloudy";
        } else if (this.code == 400) {
            return "Light Showers";
        } else if (this.code == 500) {
            return "Heavy Showers";
        } else if (this.code == 600) {
            return "Rain";
        } else if (this.code == 700) {
            return "Snow";
        } else if (this.code == 800) {
            return "Thunder";
        }
        return "Unknown";
    }

    public String beaufortConvert() {
        if (this.windSpeed == 1) {
            return "0 bft";
        } else if (this.windSpeed > 1 && this.windSpeed <= 5) {
            return "1 bft";
        } else if (this.windSpeed >= 6 && this.windSpeed <= 11) {
            return "2 bft";
        } else if (this.windSpeed >= 12 && this.windSpeed <= 19) {
            return "3 bft";
        } else if (this.windSpeed >= 20 && this.windSpeed <= 28) {
            return "4 bft";
        } else if (this.windSpeed >= 29 && this.windSpeed <= 38) {
            return "5 bft";
        } else if (this.windSpeed >= 39 && this.windSpeed <= 49) {
            return "6 bft";
        } else if (this.windSpeed >= 50 && this.windSpeed <= 61) {
            return "7 bft";
        } else if (this.windSpeed >= 62 && this.windSpeed <= 74) {
            return "8 bft";
        } else if (this.windSpeed >= 75 && this.windSpeed <= 88) {
            return "9 bft";
        } else if (this.windSpeed >= 89 && this.windSpeed <= 102) {
            return "10 bft";
        } else if (this.windSpeed >= 103 && this.windSpeed <= 117) {
            return "11 bft";
        }
        return "Day After Tomorrow Type Of Weather";
    }

    public double convertToFarenheit() {
        if (this.temperature >= 0) {
            return ((this.temperature * 9 / 5) + 32);
        }
        return this.temperature;

    }

    public String windCompass() {
        if (this.windDirection > 348.75 || this.windDirection < 11.25) {
            return "North";
        } else if (this.windDirection >= 11.25 && this.windDirection < 33.75) {
            return "North North East";
        } else if (this.windDirection >= 33.75 && this.windDirection < 56.25) {
            return "North East";
        } else if (this.windDirection >= 56.25 && this.windDirection < 78.75) {
            return "East North East";
        } else if (this.windDirection >= 78.75 && this.windDirection < 101.25) {
            return "East";
        } else if (this.windDirection >= 101.25 && this.windDirection < 123.75) {
            return "East South East";
        } else if (this.windDirection >= 123.75 && this.windDirection < 146.25) {
            return "South East";
        } else if (this.windDirection >= 146.25 && this.windDirection < 168.75) {
            return "South South East";
        } else if (this.windDirection >= 168.75 && this.windDirection < 191.25) {
            return "South";
        } else if (this.windDirection >= 191.25 && this.windDirection < 213.75) {
            return "South South West";
        } else if (this.windDirection >= 213.75 && this.windDirection < 236.25) {
            return "South West";
        } else if (this.windDirection >= 236.25 && this.windDirection < 258.75) {
            return "West South West";
        } else if (this.windDirection >= 258.75 && this.windDirection < 281.25) {
            return "West";
        } else if (this.windDirection >= 281.25 && this.windDirection < 303.75) {
            return "West North West";
        } else if (this.windDirection >= 303.75 && this.windDirection < 326.25) {
            return "North West";
        } else if (this.windDirection >= 326.25 && this.windDirection < 348.75) {
            return "North North West";
        }
        return "Incorrect Wind Direction";
    }

    public double windChill() {
        double windChill = 13.12 + (0.6215 * (this.temperature)) - (11.37 * (Math.pow(this.windSpeed, 0.16))) + ((0.3965 * (this.temperature)) * (Math.pow(this.windSpeed, 0.16)));
        return windChill;
    }
}
