package com.example.lms;

public class Books {

    private int id;
    private String title;
    private String description;
    private String edition;
    private int quantity;
    private int category_id;
    private int sub_category_id;


    public Books() {
    }

    public Books(int id, String title, String description, String edition, int quantity, int category_id, int sub_category_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.quantity = quantity;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(int sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", edition='" + edition  +
                ", quantity=" + quantity +
                ", category_id=" + category_id +
                ", subCategory_id=" + sub_category_id +
                '}';
    }
}