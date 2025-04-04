package com.yobo.tablesdisplayer.controller;

import com.yobo.tablesdisplayer.entity.TableEntity;
import com.yobo.tablesdisplayer.service.TableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
@CrossOrigin(origins = "*") // Autorise toutes les requêtes CORS (à modifier en prod)
public class TableController {
    private final TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")  // Allow CORS for this method
    public List<TableEntity> getTables() {
        List<TableEntity> list = service.getAllTables();

        for (TableEntity te:list             ) {
            System.out.println(te.getId() +" "+ te.getName());
        }
        return service.getAllTables();
    }
}