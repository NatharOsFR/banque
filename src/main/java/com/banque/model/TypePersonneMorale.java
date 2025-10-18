package com.banque.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "type_personne_morale")
public class TypePersonneMorale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_pm_seq")
    @SequenceGenerator(name = "type_pm_seq", sequenceName = "type_pm_seq", allocationSize = 1)
    private Long id;

    @Column(name = "intitule", nullable = false, columnDefinition = "TEXT")
    private String intitule;

    @OneToMany(mappedBy = "typePersonneMorale", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonneMorale> personnesMorales = new ArrayList<>();

    public TypePersonneMorale() {}
    public TypePersonneMorale(String intitule) { this.intitule = intitule; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIntitule() { return intitule; }
    public void setIntitule(String intitule) { this.intitule = intitule; }

    public List<PersonneMorale> getPersonnesMorales() { return personnesMorales; }
    public void setPersonnesMorales(List<PersonneMorale> personnesMorales) { this.personnesMorales = personnesMorales; }

    public void addPersonneMorale(PersonneMorale pm) {
        personnesMorales.add(pm);
        pm.setTypePersonneMorale(this);
    }

    public void removePersonneMorale(PersonneMorale pm) {
        personnesMorales.remove(pm);
        pm.setTypePersonneMorale(null);
    }

    @Override
    public String toString() {
        return "\nTypePersonneMorale{" +
                "id=" + id +
                ", intitule='" + intitule + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypePersonneMorale that = (TypePersonneMorale) o;
        return Objects.equals(intitule, that.intitule);
    }

    @Override
    public int hashCode() { return Objects.hash(intitule); }
}