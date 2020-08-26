package com.divitngoc.dao;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import com.divitngoc.generated.Tables;
import com.divitngoc.generated.tables.pojos.Book;

@Repository
public class BookDao extends com.divitngoc.generated.tables.daos.BookDao {

    private final DSLContext dsl;

    public BookDao(final DSLContext dsl) {
        super(dsl.configuration());
        this.dsl = dsl;
    }

    public List<Book> fetchAllBooks() {
        return dsl.selectFrom(Tables.BOOK)
                  .fetchInto(Book.class);
    }

}
