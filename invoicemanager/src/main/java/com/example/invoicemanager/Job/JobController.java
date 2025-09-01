package com.example.invoicemanager.Job;

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
@RequestMapping(path="api/v1/Job")    
public class JobController {

private final JobService JobService;


    public JobController(JobService JobService){
        this.JobService = JobService;
    }

    // @GetMapping(path="view")
    // public List<Invoice> getInvoices(){
    //     return InvoiceService.getInvoice();
    // }

    @PostMapping(path="/job/create")
    public Job Create(@RequestBody Job Job) throws JsonProcessingException{
        return JobService.Create(Job);

    }

    // @DeleteMapping(path="delete/{id}")
    //     public void deleteInvoice(@PathVariable("id") Long id){
    //         InvoiceService.deleteInvoice(id);
    //     }
    

}
