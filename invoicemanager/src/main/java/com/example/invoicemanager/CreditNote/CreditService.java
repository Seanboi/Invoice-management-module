package com.example.invoicemanager.CreditNote;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.invoicemanager.Approval.ApprovalService;
import com.example.invoicemanager.Approval.ApprovalRepo;
import com.example.invoicemanager.DomainObject.DomainObjectService;
import com.example.invoicemanager.Invoice.InvoiceRepo;

@Service
public class CreditService extends DomainObjectService<CreditNote>{

    public CreditService(CreditRepo CreditRepo,ApprovalService ApprovalService){
        super(CreditRepo,ApprovalService);
    }


}