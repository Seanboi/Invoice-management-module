package com.example.invoicemanager.CreditNote;

import com.example.invoicemanager.Approval.Approvable;
import com.example.invoicemanager.DomainObject.DomainObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "CreditNotes")
@Approvable
public class CreditNote extends DomainObject {

    public CreditNote(){
        super(null);

    }
    
}
