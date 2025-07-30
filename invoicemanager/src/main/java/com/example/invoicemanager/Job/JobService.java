package com.example.invoicemanager.Job;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.invoicemanager.Approval.ApprovalService;
import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.example.invoicemanager.Invoice.InvoiceRepo;

@Service
public class JobService extends DomainObjectService<Job> {
    

    public JobService(JobRepo JobRepo,ApprovalService ApprovalService){
        super(JobRepo,ApprovalService);
    }


}
