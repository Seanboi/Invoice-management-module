package com.example.invoicemanager.Approval;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;

public interface ApprovalRepo extends JpaRepository<Approval,Long>{
    
    List<Approval> findByApproval(ApprovalStatus approval);

    List<Approval> findByObjectType(String objectType);

    


}
