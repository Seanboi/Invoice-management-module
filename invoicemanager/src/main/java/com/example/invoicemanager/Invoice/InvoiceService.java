package com.example.invoicemanager.Invoice;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InvoiceService{

    private final InvoiceRepo InvoiceRepo;

    @Autowired
    public InvoiceService(InvoiceRepo InvoiceRepo){
        this.InvoiceRepo = InvoiceRepo;
    }

    @GetMapping
    public List<Invoice> getInvoice(){
        return InvoiceRepo.findAll();
    }

    public void deleteInvoice(Long id){
        boolean exists = InvoiceRepo.existsById(id);
        if (!exists){
            throw new IllegalStateException("Invoice does not exist");
        }
        InvoiceRepo.deleteById(id);
    }


    @PostMapping
    public void createInvoice(@RequestBody Invoice invoice){
        Optional<Invoice> invOptional = InvoiceRepo.findById(invoice.getid());
        if(invOptional.isPresent()){
            throw new IllegalStateException("id is already taken");
        }
        InvoiceRepo.save(invoice);
    }  


    


    

}
