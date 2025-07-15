package com.example.invoicemanager.DomainObject;


 public abstract class DomainObject {

    long id;

    public DomainObject(long id){
        this.id = id;
    }

    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    
}
