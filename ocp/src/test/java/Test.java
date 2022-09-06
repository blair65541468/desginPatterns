import com.citi.util.Alert;
import com.citi.util.AlertNotify;
import com.citi.util.AlertRule;

public class Test {

    @org.junit.Test
    public void testAlertNotify() {
        AlertRule alertRule = new AlertRule();
        AlertNotify alertNotify = new AlertNotify();
        Alert alert = new Alert(alertRule, alertNotify);
        Long requestCount = 1000L;
        Integer durationOfSeconds = 10;
        Long errorCount = 300L;
        String api = "ICRM";
        alert.check(api, requestCount, errorCount, durationOfSeconds);
    }

}
