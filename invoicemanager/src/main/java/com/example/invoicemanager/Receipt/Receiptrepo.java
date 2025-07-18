package com.example.invoicemanager.Receipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Receiptrepo extends JpaRepository<Receipt,Long> {}
