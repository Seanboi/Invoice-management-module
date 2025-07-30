package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;

import com.example.invoicemanager.DomainObject.DomainObject;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "approvals")
public class Approval extends DomainObject {

    public enum ApprovalStatus {
        PENDING, REJECTED, ACCEPTED
    }

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approval;
    private LocalDateTime requestedAt;
    private String objectType;
    private Long objectId;
    private String tempJson;

    // Default no-argument constructor required by JPA
    public Approval() {
        super(null);
    }

    public Approval(Long id) {
        super(id);
    }

    public Approval(Long id, ApprovalStatus approval, LocalDateTime requestedAt, String objectType, String tempJson) {
        super(id);
        this.approval = approval;
        this.requestedAt = requestedAt;
        this.objectType = objectType;
        this.objectId = id;  // or assign accordingly if different from id
        this.tempJson = tempJson;
    }

    public ApprovalStatus getApproval() {
        return approval;
    }

    public void setApproval(ApprovalStatus approval) {
        this.approval = approval;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getTempJson() {
        return tempJson;
    }

    public void setTempJson(String tempJson) {
        this.tempJson = tempJson;
    }
}
