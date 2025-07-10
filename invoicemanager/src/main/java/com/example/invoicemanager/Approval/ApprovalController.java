package com.example.invoicemanager.Approval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.invoicemanager.Invoice.InvoiceService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PutMapping("reject/{id}")
    public void RejectRequest(@PathVariable("id") long id){
        ApprovalService.RejectRequest(id);
    }

    @PutMapping("Approve/{id}")
    public void ApproveRequest(@PathVariable("id") long id){
        ApprovalService.ApproveRequest(id);
    }


     

}
