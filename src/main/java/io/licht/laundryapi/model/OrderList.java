package io.licht.laundryapi.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderList {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Menu menu;

    @ManyToOne
    @JsonIgnore
    private Order order;

    private Integer weight;
    private Integer status;

    private Date createAt;
    private Date modifyAt;
    private String createBy;
    private String modifyBy;

    public OrderList()
    {}

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
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

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
