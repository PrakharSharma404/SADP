package com.ethicalfirewall.m3.engine;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
class PolicyCache {
    // Simulating in-memory cache for ultra-low latency
    private final Map<String, String> ruleMap = new ConcurrentHashMap<>();

    public PolicyCache() {
        // Pre-load some default rules
        ruleMap.put("admin", "ALLOW");
        ruleMap.put("hacker", "DENY");
    }

    public String check(String user) {
        return ruleMap.getOrDefault(user, "DENY"); // Default deny
    }
}

@RestController
@RequestMapping("/api/check")
class EnforcementController {

    private final PolicyCache policyCache;

    public EnforcementController(PolicyCache policyCache) {
        this.policyCache = policyCache;
    }

    @GetMapping("/{user}")
    public String checkAccess(@PathVariable String user) {
        // In a real scenario, this would be an async non-blocking check
        long start = System.nanoTime();
        String result = policyCache.check(user);
        long end = System.nanoTime();
        System.out.println("Policy Check for " + user + " took " + (end - start) + " ns");

        // Asynchronous fire-and-forget to Audit (Mocked here)
        // eventPublisher.publish(new AuditEvent(user, result));

        return result;
    }
}
