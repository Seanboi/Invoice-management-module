package com.example.invoicemanager.Approval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.invoicemanager.Approval.Approval.ApprovalStatus;
import com.example.invoicemanager.Invoice.InvoiceService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path="api/v1/Approval")
public class ApprovalController {

    private final ApprovalService ApprovalService;


    public ApprovalController(ApprovalService ApprovalService){
        this.ApprovalService = ApprovalService;
    }

    @PostMapping(path="/approvals/create")
    public Approval createApprovalRequest(Long id,ApprovalStatus approval,LocalDateTime requestedAt,String ObjectType,String tempjson) {
        return ApprovalService.createApprovalRequest(id, approval, requestedAt, ObjectType, tempjson);
    }

    @DeleteMapping(path="/approvals/delete")
    public void deleteApprovalRequest(Long id){
        ApprovalService.deleteApprovalRequest(id);
    }

    @GetMapping(path="/approvals/pending")
    public List<Approval> getPending() {
        return ApprovalService.getPendingApprovals();
    }

    @GetMapping(path="/approvals/object")
    public List<Approval> getByObject(@RequestParam String objectType) {
        return ApprovalService.getApprovalsByObject(objectType);
    }

    @GetMapping(path="/approvals")
    public List<Approval> getApprovals() {
        return ApprovalService.getApprovalRequests();
    }

    @GetMapping(path="/approvals/approved")
    public List<Approval> getApproved() {
        return ApprovalService.getApprovedApprovals();
    }

    @GetMapping(path="/approvals/rejected")
    public List<Approval> getRejected() {
        return ApprovalService.getRejectedApprovals();
    }


    @PostMapping(path="/approvals/reject/{id}")
    public void RejectRequest(@PathVariable("id") long id){
        ApprovalService.RejectRequest(id);
    }

    @PostMapping(path="/approvals/approve/{id}")
    public void ApproveRequest(@PathVariable("id") long id){
        ApprovalService.ApproveRequest(id);
    }


     

}
