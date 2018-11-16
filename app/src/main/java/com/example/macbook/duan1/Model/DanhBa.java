package com.example.macbook.duan1.Model;

public class DanhBa {
    private  String dbname ,dbphone;

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDbphone() {
        return dbphone;
    }

    public void setDbphone(String dbphone) {
        this.dbphone = dbphone;
    }

    public DanhBa() {
    }

    public DanhBa(String dbname, String dbphone) {
        this.dbname = dbname;
        this.dbphone = dbphone;
    }

    @Override
    public String toString() {
        return this.dbname +"\n" + this.dbphone;
    }
}
