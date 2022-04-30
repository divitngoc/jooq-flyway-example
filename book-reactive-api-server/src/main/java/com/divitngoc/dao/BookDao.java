package com.divitngoc.dao;

import com.divitngoc.generated.Tables;
import com.divitngoc.generated.tables.pojos.Book;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class BookDao {

    private final DSLContext ctx;

    public Flux<Book> fetchAllBooks() {
        return Flux.from(ctx.selectFrom(Tables.BOOK))
                .map(b -> b.into(Book.class));
    }

    public Mono<Book> insertBook(Book book) {
        return Mono.from(ctx.insertInto(Tables.BOOK).values(book))
                .switchIfEmpty(Mono.defer(() -> Mono.error(new RuntimeException("Error with insert"))))
                .doOnNext(id -> book.setId(id))
                .thenReturn(book);
    }

}
