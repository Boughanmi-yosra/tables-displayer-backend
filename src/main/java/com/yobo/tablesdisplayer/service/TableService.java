package com.yobo.tablesdisplayer.service;

import com.yobo.tablesdisplayer.entity.TableEntity;
import com.yobo.tablesdisplayer.repository.TableRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//Testing triggers
@Service
public class TableService {
    private final TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public List<TableEntity> getAllTables() {
        return repository.findAll();
    }
}