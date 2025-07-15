package com.example.invoicemanager.CreditNote;

import org.springframework.stereotype.Service;

import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.example.invoicemanager.Invoice.InvoiceRepo;

@Service
public class CreditService extends DomainObjectService<CreditNote>{

    public CreditService(CreditRepo CreditRepo){
        super(CreditRepo);
    }

}