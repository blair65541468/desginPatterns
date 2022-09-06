package com.citi.util;

public class Alert {
    private AlertRule rule;
    private AlertNotify notify;

    public Alert(AlertRule rule, AlertNotify notify) {
        this.rule = rule;
        this.notify = notify;
    }

    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        Long maxTps = rule.getMaxTps(api);
        Long maxErrorCount = rule.getMaxErrorCount(api);

        if (tps > maxTps) {
            notify.notifyAlert("max TPS overflow...");
        }

        if (errorCount > maxErrorCount) {
            notify.notifyAlert("error count overflow...");
        }
    }
}
