package com.example.invoicemanager.Job;

import com.example.invoicemanager.DomainObject.DomainObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jobs")
public class Job extends DomainObject {

    public Job(Long id){
        super(id);
    }
    
}
