package com.example.invoicemanager.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path="api/v1/Invoice")
public class InvoiceController {

    private final InvoiceService InvoiceService;


    public InvoiceController(InvoiceService InvoiceService){
        this.InvoiceService = InvoiceService;
    }

    // @GetMapping(path="view")
    // public List<Invoice> getInvoices(){
    //     return InvoiceService.getInvoice();
    // }

    // @PostMapping(path="create")
    // public void createInvoice(@RequestBody Invoice Invoice){
    //     InvoiceService.createInvoice(Invoice);

    // }

    // @DeleteMapping(path="delete/{id}")
    //     public void deleteInvoice(@PathVariable("id") Long id){
    //         InvoiceService.deleteInvoice(id);
    //     }
    

    }
    



    

