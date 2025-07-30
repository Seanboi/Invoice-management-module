package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;

public interface ApprovalInt {

    Approval createApprovalRequest(Long id,ApprovalStatus approval,LocalDateTime requestedAt,String ObjectType,String tempjson);
    void deleteApprovalRequest(Long id);
    List<Approval> getApprovalRequests();
    List<Approval> getPendingApprovals();
    List<Approval> getApprovedApprovals();
    List<Approval> getRejectedApprovals();
    List<Approval> getApprovalsByObject(String ObjectType);
    Approval ApproveRequest(Long approvalRequestId);
    Approval RejectRequest(Long approvalRequestId);
    
}

