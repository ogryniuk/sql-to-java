package modelandcontext;

import java.time.LocalDate;

public class UserRow
{

    private int id;
    private String name;
    private String address;
    private Boolean isCustomer;
    private LocalDate created;

    public UserRow(int id, String name, String address, Boolean isCustomer, LocalDate created)
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isCustomer = isCustomer;
        this.created = created;
    }

    public Boolean getIsCustomer()
    {
        return isCustomer;
    }

    public LocalDate getCreated()
    {
        return created;
    }

    public String toStringId()
    {
        return Integer.toString(id);
    }

    public String toStringName()
    {
        return name;
    }

    public String toStringAddress()
    {
        return address;
    }

    public String toStringIsCustomer()
    {
        return String.valueOf(isCustomer);
    }

    public String toStringCreatedOn()
    {
        return String.valueOf(created);
    }
}


