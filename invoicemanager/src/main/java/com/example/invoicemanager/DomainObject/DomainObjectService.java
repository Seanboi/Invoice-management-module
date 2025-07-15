package com.example.invoicemanager.DomainObject;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class DomainObjectService<T extends DomainObject> {

protected final JpaRepository<T,Long> repository;



 public DomainObjectService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public T Create(Long id,T object){
        preCreate(id, object);
        T saved = repository.save(object);
        postCreate(id, object);
        return saved;
    }

    public T update(Long id, T object) {
        if (!repository.existsById(id)) {
            throw new IllegalStateException("Object with ID " + id + " does not exist.");
        }
        preUpdate(id, object);
        T saved = repository.save(object);
        postUpdate(saved); 
        return saved;
    }

    public void delete(Long id) {
        Optional<T> existing = repository.findById(id);
        if (existing.isEmpty()) {
            throw new IllegalStateException("Object with ID " + id + " not found.");
        }
        T obj = existing.get();
        preDelete(id);
        repository.deleteById(id);
        postDelete(id,obj);
    }

    //Hook points
    protected void preCreate(Long id, T object) {}
    protected void postCreate(Long id, T object) {}

    protected void preUpdate(Long id, T object) {}
    protected void postUpdate(T object) {}

    protected void preDelete(Long id) {}
    protected void postDelete(Long id, T deletedObject) {}




}
