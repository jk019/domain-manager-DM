package ch.zhaw.springboot.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue ("simple") //sagt, welcher Wert für die Discriminator Spalte stehen muss
public class Simple extends Element {

    // hier braucht es keine ID, da es diesen Wert von Element erbt
    private String value;

    public Simple(String name, String value){
        super(name);
        this.value = value;
    }

    //default-Konstruktor muss auch den des Supertypen aufrufen, damit Kette der Konstruktoren aufrecht erhalten bleibt. 
    public Simple(){
        super();
    }

    //getters
    public String getValue(){
        return this.value;
    }
    

    //setters
    public void setValue(String value){
        this.value = value;
    }
    public void setId(Long Id){
        super.setId(Id);
    }

    /* public String toString(){
        String result="";

        result += "<" + this.getName() +">";
        result += this.getValue();
        result += "<" + this.getName() +">";

        return result;
    } */

}
