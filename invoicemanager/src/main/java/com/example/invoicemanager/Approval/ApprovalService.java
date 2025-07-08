package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;

public class ApprovalService {

    private final ApprovalRepo ApprovalRepo;

    public ApprovalService(ApprovalRepo ApprovalRepo){
        this.ApprovalRepo = ApprovalRepo;
    }

    public void RejectRequest(Long id){
        Approval approval = ApprovalRepo.findById(id).orElseThrow();
        approval.setApproval(ApprovalStatus.REJECTED);
        approval.setRequestedAt(LocalDateTime.now());
        ApprovalRepo.save(approval);


    }

    public void ApproveRequest(Long id){
        Approval approval = ApprovalRepo.findById(id).orElseThrow();
        approval.setApproval(ApprovalStatus.ACCEPTED);
        approval.setRequestedAt(LocalDateTime.now());
        ApprovalRepo.save(approval);
    }
    
}
