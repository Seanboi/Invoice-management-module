package com.example.invoicemanager.Receipt;

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
public class ReceiptService extends DomainObjectService<Receipt> {

    public ReceiptService(Receiptrepo ReceiptRepo,ApprovalService ApprovalService){
        super(ReceiptRepo,ApprovalService);
    }

    public Receipt Create(@RequestBody Receipt object) throws JsonProcessingException{
        preCreate(object);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        if(ApprovalService.requiresApproval(object.getClass())){
            ApprovalService.createApprovalRequest(
                object.getid(), ApprovalStatus.PENDING,LocalDateTime.now(),object.getClass().getSimpleName(),json);
        }
        Receipt saved = repository.save(object);
        postCreate(object);
        return saved;
    }




    
}
