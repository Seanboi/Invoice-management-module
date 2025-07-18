package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;

import com.example.invoicemanager.DomainObject.DomainObject;
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
public class Approval extends DomainObject {
    
public enum ApprovalStatus{
    PENDING, REJECTED, ACCEPTED
}


@Enumerated(EnumType.STRING)
private ApprovalStatus approval;
private LocalDateTime requestedAt;
private String ObjectType;
private Long Objectid;
private String tempjson;
  





public Approval(Long id){
    super(id);
}

public Approval(Long id,ApprovalStatus approval,LocalDateTime requestedAt,String ObjectType,Long Objectid,String tempjson){
    super(id);
    this.approval = approval;
    this.requestedAt = requestedAt;
    this.ObjectType = ObjectType;
    this.Objectid = Objectid;
    this.tempjson = tempjson;

}


// public Long getId() { 
//     return this.id;
// }

// public void setId(Long id) {
//     this.id = id;
// }

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

public String getObjectType() {
        return ObjectType;
    }

public void setObjectType(String ObjectType) {
        this.ObjectType = ObjectType;
    }

public Long getObjectId() {
        return Objectid;
    }

public void setObjectId(Long Objectid) {
        this.Objectid = Objectid;
    }

public String getTempJson() {
        return tempjson;
    }

public void setTempJson(String tempjson) {
        this.tempjson = tempjson;
    }

}
