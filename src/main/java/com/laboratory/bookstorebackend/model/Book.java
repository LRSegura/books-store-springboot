package com.laboratory.bookstorebackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Integer year;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "writer_id", foreignKey = @ForeignKey(name = "Book_Writer_Constraint"))
    private Writer writer;
    private BigDecimal price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    private List<Sale> saleList;

    public Book(String name, Integer year, Writer writer) {
        this.name = name;
        this.year = year;
        this.writer = writer;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) && name.equals(book.name) && year.equals(book.year) && writer.equals(book.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, writer);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", writer=" + writer +
                ", price=" + price +
                ", saleList=" + saleList +
                '}';
    }
}
