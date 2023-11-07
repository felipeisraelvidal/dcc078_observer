import observer.WeatherApp;
import observer.WeatherStation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherAppTest {

    @Test
    void shouldNotifyOneApp() {
        WeatherStation station = new WeatherStation();

        WeatherApp app1 = new WeatherApp("App 1");
        app1.registerForObserver(station);

        station.setMeasurements(25.5f, 60.2f, 1013.3f);

        assertEquals("App 1 { temperature: 25.5, humidity: 60.2 };", app1.getLastNotification());
    }

    @Test
    void shouldNotifyAllApps() {
        WeatherStation station = new WeatherStation();

        WeatherApp app1 = new WeatherApp("App 1");
        app1.registerForObserver(station);

        WeatherApp app2 = new WeatherApp("App 2");
        app2.registerForObserver(station);

        station.setMeasurements(25.5f, 60.2f, 1013.3f);

        assertEquals("App 1 { temperature: 25.5, humidity: 60.2 };", app1.getLastNotification());
        assertEquals("App 2 { temperature: 25.5, humidity: 60.2 };", app2.getLastNotification());
    }

    @Test
    void shouldNotNotifyApps() {
        WeatherStation station = new WeatherStation();

        WeatherApp app1 = new WeatherApp("App 1");

        station.setMeasurements(25.5f, 60.2f, 1013.3f);

        assertEquals(null, app1.getLastNotification());
    }
}
