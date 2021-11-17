package io.licht.laundryapi.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu 
{
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Double price;
    private String menuNo;
    private Integer subMenuId;
    private Integer status;
    private Date createAt;
    private Date modifyAt;
    private String createBy;
    private String modifyBy;
    private String description;
    
    public Menu()
    {

    }

    public UUID getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Integer getSubMenuId()
    {
        return subMenuId;
    }

    public void setSubMenuId(Integer subMenuId)
    {
        this.subMenuId = subMenuId;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getMenuNo()
    {
        return menuNo;
    }

    public void setMenuNo(String menuNo)
    {
        this.menuNo = menuNo;
    }

}
