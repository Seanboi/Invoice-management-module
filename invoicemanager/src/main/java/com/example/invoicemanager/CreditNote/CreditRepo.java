package com.example.invoicemanager.CreditNote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CreditRepo extends JpaRepository<CreditNote,Long> {
    
}
