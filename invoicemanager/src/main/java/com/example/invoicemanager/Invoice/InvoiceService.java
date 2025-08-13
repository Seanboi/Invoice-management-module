package com.example.invoicemanager.Invoice;
import java.time.LocalDateTime;
import java.util.*;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;
import com.example.invoicemanager.Approval.ApprovalService;
import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InvoiceService extends DomainObjectService<Invoice>{

    

    public InvoiceService(InvoiceRepo InvoiceRepo,ApprovalService ApprovalService){
        super(InvoiceRepo, ApprovalService);
    }


    public Invoice Create(@RequestBody Invoice object) throws JsonProcessingException{
        preCreate(object);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(object);
        if(ApprovalService.requiresApproval(object.getClass())){
            ApprovalService.createApprovalRequest(
                object.getid(), ApprovalStatus.PENDING,LocalDateTime.now(),object.getClass().getSimpleName(),json);
        }
        Invoice saved = repository.save(object);
        postCreate(object);
        return saved;
    }



    

    // @GetMapping
    // public List<Invoice> getInvoice(){
    //     return InvoiceRepo.findAll();
    // }

    // public void deleteInvoice(Long id){
    //     boolean exists = InvoiceRepo.existsById(id);
    //     if (!exists){
    //         throw new IllegalStateException("Invoice does not exist");
    //     }
    //     InvoiceRepo.deleteById(id);
    // }


    // @PostMapping
    // public void createInvoice(@RequestBody Invoice invoice){
    //     Optional<Invoice> invOptional = InvoiceRepo.findById(invoice.getid());
    //     if(invOptional.isPresent()){
    //         throw new IllegalStateException("id is already taken");
    //     }
    //     InvoiceRepo.save(invoice);
    // }  


    protected void preCreate(Invoice object) {
        }
    protected void postCreate(Invoice object) {

    }

    protected void preUpdate(Invoice object) {}
    protected void postUpdate(Invoice object) {}

    protected void preDelete(Long id) {}
    protected void postDelete(Invoice deletedObject) {}


    

}
