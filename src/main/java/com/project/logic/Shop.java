package com.project.logic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleksandr on 4/7/2015.
 */
@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", length=20)
    private String name;
    @Column(name = "description", length = 100)
    private String description;

    @OneToOne
    private Photo photo;

    @ManyToOne
    private Manager manager;

//    @OneToMany(mappedBy = "shop", fetch = FetchType.EAGER)
//    private Set<Dish> dishes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Set<Dish> getDishes() {
//        return dishes;
//    }
//
//    public void setDishes(Set<Dish> dishes) {
//        this.dishes = dishes;
//    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;

        Shop shop = (Shop) o;

        if (id != null ? !id.equals(shop.id) : shop.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", manager=" + manager +
//                ", dishes=" + dishes +
                '}';
    }


}
