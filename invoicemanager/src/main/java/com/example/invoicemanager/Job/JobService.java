package com.example.invoicemanager.Job;

import org.springframework.stereotype.Service;

import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.example.invoicemanager.Invoice.InvoiceRepo;

@Service
public class JobService extends DomainObjectService<Job> {
    

    public JobService(JobRepo JobRepo){
        super(JobRepo);
    }
}
