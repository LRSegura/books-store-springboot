package com.laboratory.bookstorebackend.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "Sale_Customer_Constraint"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "Sale_Book_Constraint"))
    private Book book;

    private LocalDate saleDate;
    private Integer amount;
    private BigDecimal total;

    public Sale(Customer customer, Book book, LocalDate saleDate, Integer amount, BigDecimal total) {
        this.customer = customer;
        this.book = book;
        this.saleDate = saleDate;
        this.amount = amount;
        this.total = total;
    }

    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id.equals(sale.id) && customer.equals(sale.customer) && book.equals(sale.book) && saleDate.equals(sale.saleDate) && amount.equals(sale.amount) && total.equals(sale.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, book, saleDate, amount, total);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", customer=" + customer +
                ", book=" + book +
                ", saleDate=" + saleDate +
                ", amount=" + amount +
                ", total=" + total +
                '}';
    }
}
