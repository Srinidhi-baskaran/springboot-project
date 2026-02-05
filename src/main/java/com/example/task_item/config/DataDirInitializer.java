package com.example.task_item.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataDirInitializer implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        File dataDir = new File("./data");
        if (!dataDir.exists()) {
            boolean created = dataDir.mkdirs();
            if (!created) {
                System.err.println("Warning: could not create data directory: " + dataDir.getAbsolutePath());
            } else {
                System.out.println("Created data directory: " + dataDir.getAbsolutePath());
            }
        }
    }
}
