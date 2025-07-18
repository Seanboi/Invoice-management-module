package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;

public interface ApprovalInt {

    Approval createApprovalRequest(Long id,ApprovalStatus approval,LocalDateTime requestedAt,String ObjectType,Long Objectid,String tempjson);
    Optional<Approval> getApprovalRequest(Long id);
    List<Approval> getPendingApprovals();
    List<Approval> getApprovalsByObject(String ObjectType, Long Objectid);
    Approval ApproveRequest(Long approvalRequestId);
    Approval RejectRequest(Long approvalRequestId);
    
}

