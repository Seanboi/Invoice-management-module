package com.example.invoicemanager.Invoice;
import com.example.invoicemanager.DomainObject.DomainObject;
import java.time.LocalDate;


import com.example.invoicemanager.Approval.Approval;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Invoices")
public class Invoice extends DomainObject{
    private String name;
    private String address;
    private String number;
    private String item;
    private LocalDate date;
    private Float itemprice;
    private Integer amount;
    private Approval approval;






    public Invoice(Long id){
        super(id);
    }

    public Invoice(Long id,String name, String address, String number, String item,LocalDate date,Float itemprice,Integer amount,Approval approval){
        super(id);
        this.name = name;
        this.address = address;
        this.number = number;
        this.item = item;
        this.date = date;
        this.itemprice = itemprice;
        this.amount = amount;
        this.approval = approval;
    }


    // public Long getid() {
    //     return this.id;
    // }

    // public void setid(Long id) {
    //     this.id = id;
    // }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getItemprice() {
        return this.itemprice;
    }

    public void setItemprice(Float itemprice) {
        this.itemprice = itemprice;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
