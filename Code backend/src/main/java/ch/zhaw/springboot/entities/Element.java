package ch.zhaw.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
@DiscriminatorColumn(name ="dtype") // sagt bei Single-Table, welche Spalte den Typ bestimmt
public class Element {

    @Id
    private long id;

    private String name;

    @ManyToOne
    private Complex parent; // zu 1 Beziehung zu Complex

    @Column(insertable = false, updatable = false) //darf nicht für insert und update verwendet werden
    private String dtype;

    public Element(String name) {
        this.name = name;
        this.parent = null; // Damit man sicher ist, dass nicht schon ein Parent gsetzt ist.
    }

    public Element() {
    }

    // getters:
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDtype() {
        return dtype;
    }

    public Complex getParent() {
        return parent;
    }

    // setters:

    public void setParent(Complex parent) {
        this.parent = parent;
        /* parent.addChild(this); // damit wird das Element direkt dem parent hinzugefügt */
    }

    public void setName(String name){
        this.name=name;
    }

    public void setId(Long id){
        this.id = id;
    }

}
