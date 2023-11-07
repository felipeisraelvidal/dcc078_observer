package observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherApp implements Observer {
    private float temperature;
    private float humidity;

    private String appName;

    private String lastNotification;

    public WeatherApp(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return this.appName;
    }

    public void registerForObserver(WeatherStation station) {
        station.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherStation) {
            WeatherStation station = (WeatherStation) o;
            this.temperature = station.getTemperature();
            this.humidity = station.getHumidity();

            this.lastNotification = this.appName + " { temperature: " + this.temperature + ", humidity: " + this.humidity + " };";
        }
    }

    public String getLastNotification() {
        return this.lastNotification;
    }
}
