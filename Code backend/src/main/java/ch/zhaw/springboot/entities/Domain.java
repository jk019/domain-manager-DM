package ch.zhaw.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Domain {

    @Id
    private long id;

    private String name;
    private String IP;
    

    public Domain(long id, String name, String IP) {
        this.id = id;
        this.name = name;
        this.IP = IP;
    }

    public Domain() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setIp(String ip){
        this.IP = ip;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

}
