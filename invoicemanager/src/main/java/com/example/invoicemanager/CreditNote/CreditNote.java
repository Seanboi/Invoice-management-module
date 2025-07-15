package com.example.invoicemanager.CreditNote;

import com.example.invoicemanager.DomainObject.DomainObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "CreditNotes")
public class CreditNote extends DomainObject {

    public CreditNote(Long id){
        super(id);

    }
    
}
