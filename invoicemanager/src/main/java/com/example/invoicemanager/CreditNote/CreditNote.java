package com.example.invoicemanager.CreditNote;

import com.example.invoicemanager.Approval.Approvable;
import com.example.invoicemanager.DomainObject.DomainObject;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "CreditNotes")
@Approvable
public class CreditNote extends DomainObject {

    private String name;
    private String address;
    private String number;
    private String item;
    @JsonFormat(pattern = "YYYY-MM-DDTHH:mm:ss.sssZ")
    private String date;
    private Float itemprice;
    private Integer amount;
    private String company;
    private String companyaddr;


    public CreditNote(){
        super();
     

    }

    public CreditNote(Long id,String name, String address, String number, String item,String date,Float itemprice,Integer amount,String company,String companyaddr,boolean approvable){
        super(id, approvable);
        this.name = name;
        this.address = address;
        this.number = number;
        this.item = item;
        this.date = date;
        this.itemprice = itemprice;
        this.amount = amount;

    }
    
}
