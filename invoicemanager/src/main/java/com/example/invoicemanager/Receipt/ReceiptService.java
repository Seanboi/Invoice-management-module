package com.example.invoicemanager.Receipt;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.invoicemanager.Approval.ApprovalService;
import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.example.invoicemanager.Invoice.InvoiceRepo;

@Service
public class ReceiptService extends DomainObjectService<Receipt> {

    public ReceiptService(Receiptrepo ReceiptRepo,ApprovalService ApprovalService){
        super(ReceiptRepo,ApprovalService);
    }

    public Optional<Receipt> findById(Long id) {
        return repository.findById(id);
    }


    
}
