package com.example.invoicemanager.Approval;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public abstract class ApprovalObjectService<T extends ApprovalObject> {

protected final JpaRepository<T,Long> repository;

protected ApprovalService ApprovalService;


 public ApprovalObjectService(JpaRepository<T, Long> repository) {
        this.repository = repository;
        
    }

 public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

}
