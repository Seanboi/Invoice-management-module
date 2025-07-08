package com.example.invoicemanager.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;



@Repository
public interface InvoiceRepo extends JpaRepository<Invoice,Long>{

    
}
