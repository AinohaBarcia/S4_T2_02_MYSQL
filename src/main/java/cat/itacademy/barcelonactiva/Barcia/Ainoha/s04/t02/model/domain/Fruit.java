package cat.itacademy.barcelonactiva.Barcia.Ainoha.s04.t02.model.domain;

import jakarta.persistence.*;



@Entity
@Table(name = "Fruits")

public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float amountKilos;

    public Fruit(int id, String name, float amountKilos) {
        this.id = id;
        this.name = name;
        this.amountKilos = amountKilos;
    }

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

    public float getAmountKilos() {
        return amountKilos;
    }

    public void setAmountKilos(float amountKilos) {
        this.amountKilos = amountKilos;
    }
}
