package com.ethicalfirewall.m5.controller;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    private static final String AUDIT_FILE = "audit.log";

    @PostMapping
    public void logEvent(@RequestBody String eventPayload) {
        String logEntry = LocalDateTime.now() + " - " + eventPayload + "\n";
        try {
            // Append-only write simulation
            Files.write(Paths.get(AUDIT_FILE), logEntry.getBytes(), StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            System.out.println("Audited: " + logEntry.trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
