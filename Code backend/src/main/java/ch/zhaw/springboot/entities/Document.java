package ch.zhaw.springboot.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Document {

    @Id
    private long id;

    private Date creation_date;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private Domain domain;

    @ManyToOne
    private Element element;

    public Document(Date creation_date, Domain domain, Element element) {
        this.creation_date = creation_date;
        this.domain = domain;
        this.element = element;
    }

    Document() {
    }

    public long getId() {
        return id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public Domain getDomain() {
        return domain;
    }

    public Element getElement() {
        return element;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
