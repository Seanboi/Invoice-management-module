package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;

public class Approval {
    
public enum ApprovalStatus{
    PENDING, REJECTED, ACCEPTED
}

private Long id;
private ApprovalStatus approval;
private LocalDateTime requestedAt;




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
