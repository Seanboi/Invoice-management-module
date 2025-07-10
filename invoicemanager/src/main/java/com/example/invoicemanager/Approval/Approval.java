package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;

import com.example.invoicemanager.Invoice.Invoice;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "approvals")
public class Approval {
    
public enum ApprovalStatus{
    PENDING, REJECTED, ACCEPTED
}

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Enumerated(EnumType.STRING)
private ApprovalStatus approval;
private LocalDateTime requestedAt;

@OneToOne(mappedBy = "approvals")
private Invoice invoice;




public Approval(){}

public Approval(Long id, ApprovalStatus approval,LocalDateTime requestedAt){
    this.id = id;
    this.approval = approval;
    this.requestedAt = requestedAt;

}


public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}

public ApprovalStatus getApproval() {
    return this.approval;
}

public void setApproval(ApprovalStatus approval) {
    this.approval = approval;
}

public LocalDateTime getRequestedAt() {
    return this.requestedAt;
}

public void setRequestedAt(LocalDateTime requestedAt) {
    this.requestedAt = requestedAt;
}

}
