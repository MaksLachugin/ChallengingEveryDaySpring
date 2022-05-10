package ru.vsu.cs.lachugin.dao;

import ru.vsu.cs.lachugin.models.BaseModel;

import java.util.List;

public interface IDAO<T extends BaseModel> {
    List<T> index();

    T show(int id);

    T save(T obj);

    T update(int id, T updatedObj);

    T findByParams(T obj);

    T delete(int id);

    void clean();

    List<T> saveAll(List<T> objs);
}
