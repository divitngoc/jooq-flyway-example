package com.divitngoc.dao;

import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.divitngoc.generated.Tables;
import com.divitngoc.generated.tables.pojos.Book;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class BookDao {

    private final DatabaseClient databaseClient;

    public Flux<Book> fetchAllBooks() {
        return databaseClient.execute(DSL.using(SQLDialect.MYSQL)
                                         .selectFrom(Tables.BOOK)
                                         .getSQL())
                             .as(Book.class)
                             .fetch()
                             .all();
    }

    public Mono<Book> insertBook(Book book) {
        return databaseClient.insert()
                             .into(Book.class)
                             .table(Tables.BOOK.getName())
                             .using(book)
                             .map((r, m) -> r.get(0, Integer.class))
                             .first()
                             .map(id -> {
                                 book.setId(id);
                                 return book;
                             })
                             .switchIfEmpty(Mono.defer(() -> Mono.error(new RuntimeException("Error with insert"))));
    }

}
