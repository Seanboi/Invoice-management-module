package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;
import com.example.invoicemanager.DomainObject.DomainObjectService;

public class ApprovalService extends DomainObjectService<Approval> implements ApprovalInt {


    public ApprovalService(ApprovalRepo ApprovalRepo){
        super(ApprovalRepo);
    }

    public Approval createApprovalRequest(Long id,ApprovalStatus approval,LocalDateTime requestedAt,String ObjectType,Long Objectid,String tempjson){

        Approval request = new Approval(id);
        request.setApproval(ApprovalStatus.PENDING);
        request.setObjectId(id);
        request.setObjectType(ObjectType);
        request.setRequestedAt(requestedAt);
        request.setTempJson(tempjson);

        return repository.save(request);
    
    }

    public Optional<Approval> getApprovalRequest(Long id){
        return repository.findById(id);

    }

    public List<Approval> getPendingApprovals(){
        return ((ApprovalRepo) repository).findByApproval(ApprovalStatus.PENDING);

    }


    public List<Approval> getApprovalsByObject(String ObjectType, Long Objectid){
        return((ApprovalRepo)repository).findByObjectType(ObjectType,Objectid);


    }


    public Approval RejectRequest(Long id){
        Approval approval = repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Request not found"));
        approval.setApproval(ApprovalStatus.REJECTED);
        return repository.save(approval);
    }
 
    

    public Approval ApproveRequest(Long id){
        Approval approval = repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Request not found"));
        approval.setApproval(ApprovalStatus.ACCEPTED);
        return repository.save(approval);
    }



    
}
