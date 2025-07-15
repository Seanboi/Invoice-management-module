package com.example.invoicemanager.Receipt;

import org.springframework.stereotype.Service;

import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.example.invoicemanager.Invoice.InvoiceRepo;

@Service
public class ReceiptService extends DomainObjectService<Receipt> {

    public ReceiptService(Receiptrepo ReceiptRepo){
        super(ReceiptRepo);
    }
    
}
