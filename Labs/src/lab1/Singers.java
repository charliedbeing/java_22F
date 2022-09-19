package lab1;

import java.util.Date;

public class Singers {
    private int id;
    private String name;
    private String address;
    private Date   birthday;
    private int albumsPublished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAlbumsPublished() {
        return albumsPublished;
    }

    public void setAlbumsPublished(int albumsPublished) {
        this.albumsPublished = albumsPublished;
    }


    public void setAll(int id,String name,String address,Date birthday,int albumsPublished){
        this.id =id;
        this.name = name;
        this.address =address;
        this.birthday = birthday;
        this.albumsPublished = albumsPublished;
    }

    public Singers(){}
    public Singers(int id){
        this.id =id;
    }
    public Singers(int id,String name){
        this.id =id;
        this.name = name;
    }
    public Singers(int id,String name,String address){
        this(id,name);
        this.address = address;
    }
    public Singers(int id,String name,String address,Date birthday){
        this(id,name,address);
        this.birthday=birthday;

    }
    public Singers(int id,String name,String address,Date birthday,int albumsPublished){
        this(id,name,address,birthday);
        this.albumsPublished = albumsPublished;

    }

    @Override
    public String toString() {
        return "| id:" + this.id +"| name: " +this.name +"| address :" + this.address + "| birthday: " + this.birthday +"| albumsPublished: " + this.albumsPublished+" |";
    }
}
