package com.example.invoicemanager.CreditNote;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.invoicemanager.Invoice.Invoice;

public interface CreditRepo extends JpaRepository<CreditNote,Long> {
    
}
