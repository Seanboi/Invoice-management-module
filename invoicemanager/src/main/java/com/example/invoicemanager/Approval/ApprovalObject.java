package com.example.invoicemanager.Approval;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ApprovalObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    

    public ApprovalObject(){}

    public ApprovalObject(Long id){
        this.id = id;
        
    }

    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
}