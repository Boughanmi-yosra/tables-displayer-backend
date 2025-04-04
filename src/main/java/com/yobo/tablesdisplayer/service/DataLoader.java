package com.yobo.tablesdisplayer.service;

import com.yobo.tablesdisplayer.entity.TableEntity;
import com.yobo.tablesdisplayer.repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TableRepository tableRepository;

    public DataLoader(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserting sample data at startup
        if (tableRepository.count() == 0) {
            tableRepository.save(new TableEntity( "Table1", "Value1"));
            tableRepository.save(new TableEntity( "Table2", "Value2"));
            tableRepository.save(new TableEntity( "Table3", "Value3"));
            System.out.println("Data inserted at startup!");
        }
    }
}
