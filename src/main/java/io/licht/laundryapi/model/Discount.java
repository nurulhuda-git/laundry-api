package io.licht.laundryapi.model;

public class Discount 
{
    private Integer id;
    private Integer menuId;
    private String name;
    private Boolean status;
    private Double price;
    private Integer multiplier;

    public Discount()
    {
        
    }

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public Integer getMenuId()
    {
        return menuId;
    }
    public void setMenuId(Integer menuId)
    {
        this.menuId = menuId;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Boolean getStatus()
    {
        return status;
    }
    public void setStatus(Boolean status)
    {
        this.status = status;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public Integer getMultiplier()
    {
        return multiplier;
    }
    public void setMultiplier(Integer multiplier)
    {
        this.multiplier = multiplier;
    }

    
    
}
