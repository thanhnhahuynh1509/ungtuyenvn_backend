package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.exception.model.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseService<T, ID> {

    protected final JpaRepository<T, ID> baseRepository;
    private final String serviceName;

    public BaseService(JpaRepository<T, ID> baseRepository, String serviceName) {
        this.baseRepository = baseRepository;
        this.serviceName = serviceName;
    }

    public T save(T model) {
        return baseRepository.save(model);
    }

    public List<T> gets() {
        return baseRepository.findAll();
    }

    public T get(ID id) {
        return getSingleResultById(id);
    }

    public abstract T update(ID id, T model);

    public void delete(ID id) {
        T model = getSingleResultById(id);
        baseRepository.delete(model);
    }

    protected T getSingleResultById(ID id) {
        return baseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay " + serviceName + " voi id: " + id));
    }
}
