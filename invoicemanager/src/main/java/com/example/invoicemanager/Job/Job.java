package com.example.invoicemanager.Job;

import com.example.invoicemanager.Approval.Approvable;
import com.example.invoicemanager.DomainObject.DomainObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Jobs")
@Approvable
public class Job extends DomainObject {

    private String name;
    private String address;
    private String number;
    private String position;
    @JsonFormat(pattern = "YYYY-MM-DDTHH:mm:ss.sssZ")
    private String date;
    private Float salary;
 

    public Job(){
        super();
    }

     public Job(Long id,String name, String address, String number, String position,String date,Float salary,boolean approvable){
        super(id, approvable);
        this.name = name;
        this.address = address;
        this.number = number;
        this.position = position;
        this.date = date;
        this.salary = salary;
        

    }
    
    
}
