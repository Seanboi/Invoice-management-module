package com.example.invoicemanager.DomainObject;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean approvable;

     public DomainObject(){}

    public DomainObject(Long id,boolean approvable){
        this.id = id;
        this.approvable = approvable;
    }

    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }

    public boolean isApprovable() {
        return this.approvable;
    }

    public void setApprovable(boolean approvable) {
        this.approvable = approvable;
    }

    

    
}
