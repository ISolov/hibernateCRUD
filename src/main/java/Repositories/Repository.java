package Repositories;

import java.util.List;

public interface Repository<T> {
    T getById(Long id);
    List<T> getAll();
    void add(T data);
    void update(T data);
}
