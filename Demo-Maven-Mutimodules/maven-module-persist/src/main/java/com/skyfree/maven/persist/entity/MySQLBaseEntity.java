package com.skyfree.maven.persist.entity;

public class MySQLBaseEntity {
    protected Integer id;
    protected Byte isValid;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Byte getIsValid() {
        return isValid;
    }
    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    } 
}
