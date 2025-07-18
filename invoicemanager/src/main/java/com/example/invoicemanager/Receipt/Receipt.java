package com.example.invoicemanager.Receipt;

import com.example.invoicemanager.Approval.Approvable;
import com.example.invoicemanager.DomainObject.DomainObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Receipts")
@Approvable
public class Receipt extends DomainObject {

    public Receipt(Long id){
        super(id);
    }
    
}
