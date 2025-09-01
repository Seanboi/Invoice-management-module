package com.example.invoicemanager.Job;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;
import com.example.invoicemanager.Approval.ApprovalService;
import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.example.invoicemanager.Invoice.Invoice;
import com.example.invoicemanager.Invoice.InvoiceRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JobService extends DomainObjectService<Job> {
    

    public JobService(JobRepo JobRepo,ApprovalService ApprovalService){
        super(JobRepo,ApprovalService);
    }

    public Job Create(@RequestBody Job object) throws JsonProcessingException{
        preCreate(object);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        if(ApprovalService.requiresApproval(object.getClass())){
            ApprovalService.createApprovalRequest(
                object.getid(), ApprovalStatus.PENDING,LocalDateTime.now(),object.getClass().getSimpleName(),json);
        }
        Job saved = repository.save(object);
        postCreate(object);
        return saved;
    }


}
