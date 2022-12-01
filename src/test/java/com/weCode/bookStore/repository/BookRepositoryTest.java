package com.weCode.bookStore.repository;

import com.weCode.bookStore.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Sql(scripts = {"classpath:insertInitialBookRecordsForTest.sql"})
    public void giveBookRepositoryWhenFetchedReturnAll(){

        List<Book> bookList = bookRepository.findAll();
        bookList.forEach( b->{
            System.out.println(b);
        });

        Assertions.assertThat(bookList).hasSize(3);

    }


    public void givenBookRepositoryWhenTitleReturnBook(){


    }



}
