package com.ethicalfirewall.m2.plugin;

import org.springframework.stereotype.Component;

@Component
public class SyntaxValidator implements PolicyValidator {
    @Override
    public boolean validate(String policy) {
        // Simple check: Rule must start with "ALLOW" or "DENY"
        return policy != null && (policy.startsWith("ALLOW") || policy.startsWith("DENY"));
    }

    @Override
    public String getName() {
        return "Syntax Checker";
    }
}
