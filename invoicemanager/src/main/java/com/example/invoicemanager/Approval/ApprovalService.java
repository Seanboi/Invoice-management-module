package com.example.invoicemanager.Approval;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;
import com.example.invoicemanager.DomainObject.DomainObjectService;

@Service
public class ApprovalService extends ApprovalObjectService<Approval> implements ApprovalInt {

    
    public ApprovalService(ApprovalRepo ApprovalRepo){
        super(ApprovalRepo);
    }

    public Approval createApprovalRequest(Long id,ApprovalStatus approval,LocalDateTime requestedAt,String objectType,String tempJson){

        Approval request = new Approval(id);
        request.setApproval(ApprovalStatus.PENDING);
        request.setObjectId(id);
        request.setObjectType(objectType);
        request.setRequestedAt(requestedAt);
        request.setTempJson(tempJson);

        return repository.save(request);
    
    }


    public void deleteApprovalRequest(Long id){
        Approval approval = repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Request not found"));
        repository.delete(approval);
    }

    public List<Approval> getApprovalRequests(){
        return repository.findAll();
        

    }

    public List<Approval> getPendingApprovals(){
        return ((ApprovalRepo) repository).findByApproval(ApprovalStatus.PENDING);

    }

    public List<Approval> getApprovedApprovals(){
        return ((ApprovalRepo) repository).findByApproval(ApprovalStatus.ACCEPTED);
    }

    public List<Approval> getRejectedApprovals(){
        return ((ApprovalRepo) repository).findByApproval(ApprovalStatus.REJECTED);
    }




    public List<Approval> getApprovalsByObject(String ObjectType){
        return((ApprovalRepo)repository).findByObjectType(ObjectType);


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

    public boolean requiresApproval(Class<?> clazz) {
        return clazz.isAnnotationPresent(Approvable.class);
}




    
}
