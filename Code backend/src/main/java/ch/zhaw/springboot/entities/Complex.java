package ch.zhaw.springboot.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue ("complex") //sagt, welcher Wert für die Discriminator Spalte stehen muss
public class Complex extends Element {

    // hier braucht es keine ID, da es diesen Wert von Element erbt
    private String type;

    @OneToMany
    private Set<Element> children; // Liste mit allen Elementen, die sich in Complex befinden

    public Complex(String name, String type) {
        super(name);
        this.type = type;
        this.children = new HashSet<Element>();
    }

    // default-Konstruktor muss auch den des Supertypen aufrufen, damit Kette der
    // Konstruktoren aufrecht erhalten bleibt.
    public Complex() {
        super();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    
    public void addChild(Element child) { // Child ist Element, da es so beide Typen haben kann
        if (!this.children.contains(child)) { // Child wird nur hinzugefügt, wenn es noch nicht darin besteht
            this.children.add(child);
            if (child.getParent() == null) { // Überprüfen, ob es schon einen parent hat. nicht hinzufügen wenn es schon
                                             // einen hat, sonst endet es in Endlosschlaufe
                child.setParent(this); // Damit wird der parent direkt richtig gesetzt.
            }
        }
    }



    /*
     * public String toString(){
     * String result="";
     * 
     * result += "<" + this.getName() +">";
     * result += this.getType();
     * result += "<" + this.getName() +">";
     * 
     * return result;
     * }
     */
}
