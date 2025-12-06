package com.ethicalfirewall.m2.plugin;

public interface PolicyValidator {
    boolean validate(String policyDefinition);

    String getName();
}
