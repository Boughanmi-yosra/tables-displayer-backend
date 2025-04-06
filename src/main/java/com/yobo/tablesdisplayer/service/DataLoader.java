package com.yobo.tablesdisplayer.service;

import com.yobo.tablesdisplayer.entity.TableEntity;
import com.yobo.tablesdisplayer.entity.User;
import com.yobo.tablesdisplayer.repository.TableRepository;
import com.yobo.tablesdisplayer.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TableRepository tableRepository;
    private final UserRepository userRepository;

    public DataLoader(TableRepository tableRepository , UserRepository userRepository) {
        this.tableRepository = tableRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserting sample data at startup
        if (tableRepository.count() == 0) {
            tableRepository.save(new TableEntity( "Table1", "Value1"));
            tableRepository.save(new TableEntity( "Table2", "Value2"));
            tableRepository.save(new TableEntity( "Table3", "Value3"));
            System.out.println("Table Data inserted at startup!");
        }

        if (userRepository.count() == 0) {
            userRepository.save(new User( "Yosra", "yousra.boughanmi@gmail.com" ,"abcd"));
            userRepository.save(new User( "Ameni", "ameni@gmail.com","xcvx"));
            System.out.println("User Data inserted at startup!");
        }
    }
}
