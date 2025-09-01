package com.example.invoicemanager.CreditNote;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path="api/v1/Credit")
public class CreditController {

    private final CreditService CreditService;


    public CreditController(CreditService CreditService){
        this.CreditService = CreditService;
    }

    // @GetMapping(path="view")
    // public List<Invoice> getInvoices(){
    //     return InvoiceService.getInvoice();
    // }

    @PostMapping(path="/credit/create")
    public CreditNote Create(@RequestBody CreditNote Credit) throws JsonProcessingException{
        return CreditService.Create(Credit);

    }

    // @DeleteMapping(path="delete/{id}")
    //     public void deleteInvoice(@PathVariable("id") Long id){
    //         InvoiceService.deleteInvoice(id);
    //     }
    

    }
