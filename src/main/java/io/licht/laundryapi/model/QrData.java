package io.licht.laundryapi.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qr_data")
public class QrData 
{
    @Id
    @GeneratedValue
    private UUID id;
    private UUID orderId;
    private String image;

    public QrData()
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

    public UUID getOrderId()
    {
        return orderId;
    }

    public void setOrderId(UUID orderId2)
    {
        this.orderId = orderId2;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    
}
