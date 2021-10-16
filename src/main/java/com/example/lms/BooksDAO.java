package com.example.lms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public class BooksDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BooksDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Books> list() {
        String sql = "Select * from book";
        List<Books> booksList;
        booksList = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Books.class));
        return booksList;
    }

    public void save(Books books){

            SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
            insertActor.withTableName("book").usingColumns("id", "title", "description", "edition","quantity",
                    "category_id", "sub_category_id");
            BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(books);
            insertActor.execute(param);

    }
    public Books get(int id){
        String sql= "select * from book where id = ?";
        Object[] args = {id};
        Books books = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Books.class));

        return books;
    }

    public void update(Books books){
        String sql = "update book b set b.title=:title, b.description=:description, b.edition=:edition, b.quantity=:quantity " +
                ",b.category_id=:category_id, b.sub_category_id=:sub_category_id where b.id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(books);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);

    }

    public void delete(int id) {
        String sql = "delete from book where id=?";
        jdbcTemplate.update(sql,id);
    }
}
