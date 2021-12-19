package io.licht.laundryapi.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "orders")
public class Order 
{
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Customer customer;

    @Column(columnDefinition = "serial")
    @Generated(GenerationTime.INSERT)
    private Integer orderNo;

    @OneToMany(mappedBy = "order")
    private List<OrderList> orderLists;

    private Double totalAmount;
    private Double totalWeight;
    private Integer status;
    private Date createAt;
    private Date modifyAt;
    private String createBy;
    private String modifyBy;
    private UUID qrId;
    private String link;

    public Order()
    {

    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Integer getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public List<OrderList> getOrderLists()
    {
        return orderLists;
    }

    public void setOrderLists(List<OrderList> orderLists)
    {
        this.orderLists = orderLists;
    }

    public Double getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public Double getTotalWeight()
    {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight)
    {
        this.totalWeight = totalWeight;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Date getCreateAt()
    {
        return createAt;
    }

    public void setCreateAt(Date createAt)
    {
        this.createAt = createAt;
    }

    public Date getModifyAt()
    {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt)
    {
        this.modifyAt = modifyAt;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public String getModifyBy()
    {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy)
    {
        this.modifyBy = modifyBy;
    }

    public UUID getQrId()
    {
        return qrId;
    }

    public void setQrId(UUID qrId)
    {
        this.qrId = qrId;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    

}
