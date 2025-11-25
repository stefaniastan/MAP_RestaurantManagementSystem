package com.example.map_proiect_restaurant.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class InFileRepository<T> implements AbstractRepository<T> {

    private final Class<T> type;
    private final File file;
    private final ObjectMapper objectMapper;
    private List<T> data;

    public interface IdProvider {
        String getId();
        void setId(String id);
    }

    public InFileRepository(Class<T> type, String filePath) {
        this.type = type;
        this.file = new File(filePath);
        this.objectMapper = new ObjectMapper();
        this.data = loadData();
    }

    // === Load data from JSON file ===
    private List<T> loadData() {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                objectMapper.writeValue(file, new ArrayList<>());
            }

            // Correct type-safe deserialization
            return objectMapper.readValue(
                    file,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, type)
            );

        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    // === Save data to JSON file ===
    private void saveData() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T save(T entity) {
        if (!(entity instanceof IdProvider)) {
            throw new IllegalArgumentException("Entity must implement IdProvider interface");
        }

        IdProvider item = (IdProvider) entity;

        // dacă nu are ID
        if (item.getId() == null || item.getId().isEmpty()) {
            item.setId(type.getSimpleName() + "-" + UUID.randomUUID());
            data.add(entity);
        } else {
            // dacă există
            boolean updated = false;
            for (int i = 0; i < data.size(); i++) {
                IdProvider existing = (IdProvider) data.get(i);
                if (existing.getId().equals(item.getId())) {
                    data.set(i, entity);
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                data.add(entity);
            }
        }
        saveData();
        return entity;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public T findById(String id) {
        for (T t : data) {
            IdProvider item = (IdProvider) t;
            if (item.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        data.removeIf(t -> {
            IdProvider item = (IdProvider) t;
            return item.getId().equals(id);
        });
        saveData();
    }
}
//hei