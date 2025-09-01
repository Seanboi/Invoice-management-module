package com.example.invoicemanager.Receipt;

import com.example.invoicemanager.Approval.Approvable;
import com.example.invoicemanager.DomainObject.DomainObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "Receipts")
@Approvable
public class Receipt extends DomainObject {

    private String name;
    private String number;
    private String item;
    @JsonFormat(pattern = "YYYY-MM-DDTHH:mm:ss.sssZ")
    private String date;
    private Float itemprice;
  

    public Receipt(){
        super();
    }

     public Receipt(Long id,String name, String number, String item,String date,Float itemprice,boolean approvable){
        super(id, approvable);
        this.name = name;
        this.number = number;
        this.item = item;
        this.date = date;
        this.itemprice = itemprice;
       

    }
    
    
}
