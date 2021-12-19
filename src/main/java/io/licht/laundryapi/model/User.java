package io.licht.laundryapi.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User 
{
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String idCard;
    private String userName;
    private String password;
    private Integer roleId;
    private Date createAt;
    private String createBy;
    private Date modifyAt;
    private String modifyBy;

    public Date getCreateAt()
    {
        return createAt;
    }

    public void setCreateAt(Date createAt)
    {
        this.createAt = createAt;
    }

    public String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    public Date getModifyAt()
    {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt)
    {
        this.modifyAt = modifyAt;
    }

    public String getModifyBy()
    {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy)
    {
        this.modifyBy = modifyBy;
    }

    private String status;

    public User()
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getIdCard()
    {
        return idCard;
    }

    public void setIdCard(String idCard)
    {
        this.idCard = idCard;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    
}
