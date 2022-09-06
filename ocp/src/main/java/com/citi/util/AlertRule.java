package com.citi.util;

import java.util.Map;

public class AlertRule {
    Map<String, Long> maxTps =
            Map.of("ICRM", 10L, "CRC-Common-Service", 10L);
    Map<String, Long> maxErrorCount =
            Map.of("ICRM", 50L, "CRC-Common-Service", 50L);

    public Long getMaxTps(String api) {
        return maxTps.get(api);
    }

    public Long getMaxErrorCount(String api) {
        return maxErrorCount.get(api);
    }

}
