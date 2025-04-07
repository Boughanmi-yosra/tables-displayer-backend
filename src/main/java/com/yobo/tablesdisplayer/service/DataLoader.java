package com.yobo.tablesdisplayer.service;

import com.yobo.tablesdisplayer.entity.Product;
import com.yobo.tablesdisplayer.entity.TableEntity;
import com.yobo.tablesdisplayer.entity.User;
import com.yobo.tablesdisplayer.repository.ProductRepository;
import com.yobo.tablesdisplayer.repository.TableRepository;
import com.yobo.tablesdisplayer.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private final TableRepository tableRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DataLoader(TableRepository tableRepository , UserRepository userRepository ,ProductRepository productRepository ) {
        this.tableRepository = tableRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
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

        if (productRepository.count() == 0) {
            productRepository.save(new Product("IPad","Tablette tactile conçue et développée par la société américaine Apple",new BigDecimal(1125.1),2000));
            productRepository.save(new Product( "IPone 15","« Super Retina XDR » de 6,1 pouces et une définition de 2556 x 1179 pixels pour le Pro",new BigDecimal(3125.1),2700));
            productRepository.save(new Product( "Pc Portable Dell Inspiron 5559 / i5 6è Gén / 8 Go / Noir","Ecran 15.6 Processeur Intel Core i5-6200U 6è Génération, up to 2.8 Ghz , 3 Mo de mémoire cache - Mémoire 8 Go - Disque 1 To - Carte graphique AMD",new BigDecimal(1311.255),2000));
            System.out.println("User Data inserted at startup!");
        }
    }
}
