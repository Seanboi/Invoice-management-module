package com.example.invoicemanager.DomainObject;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.invoicemanager.Approval.ApprovalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.invoicemanager.Approval.Approval.ApprovalStatus;

public abstract class DomainObjectService<T extends DomainObject> {

protected final JpaRepository<T,Long> repository;

protected ApprovalService ApprovalService;



 public DomainObjectService(JpaRepository<T, Long> repository,ApprovalService ApprovalService) {
        this.repository = repository;
        this.ApprovalService = ApprovalService;
    }

    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    public T Create(T object) throws JsonProcessingException{
        preCreate(object);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        if(ApprovalService.requiresApproval(object.getClass())){
            ApprovalService.createApprovalRequest(
                object.getid(), ApprovalStatus.PENDING,LocalDateTime.now(),object.getClass().getName(),json);
        }
        T saved = repository.save(object);
        postCreate(object);
        return saved;
    }

    public T update(T object)throws JsonProcessingException {
        if (!repository.existsById(object.getid())) {
            throw new IllegalStateException("Object with ID " + object.getid() + " does not exist.");
        }
        if(ApprovalService.requiresApproval(object.getClass())){
            preUpdate(object);
        }
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
        postDelete(obj);
    }

    //Hook points
    protected void preCreate(T object) {}
    protected void postCreate(T object) {}

    protected void preUpdate(T object) {}
    protected void postUpdate(T object) {}

    protected void preDelete(Long id) {}
    protected void postDelete(T deletedObject) {}




}
