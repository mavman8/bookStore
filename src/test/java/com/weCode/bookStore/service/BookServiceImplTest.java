package com.weCode.bookStore.service;

import com.weCode.bookStore.dto.BookDTO;
import com.weCode.bookStore.model.Book;
import com.weCode.bookStore.repository.BookRepository;
import com.weCode.bookStore.service.Impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ModelMapper mapper;

    @Test
    void shouldReturnListOfBookDtoWhenGetBooksCalled(){
        List<Book> bookList = new ArrayList<>();
        var book = getBook();
        bookList.add(book);

        BookDTO bookDTO = new BookDTO();
        List<BookDTO> bookDTOs = bookService.getBooks();

        when(bookRepository.findAll()).thenReturn(bookList);
        when(mapper.map(book, BookDTO.class)).thenReturn(bookDTO);
        assertThat(1).isEqualTo(bookList.size());
        assertThat(bookDTOs.get(0))
                .isNotNull()
                .hasFieldOrPropertyWithValue("title", "test title")
                .hasFieldOrPropertyWithValue("description", "test description")
                .hasFieldOrPropertyWithValue("releaseYear", 2020);


    }

    private Book getBook(){

        return Book.builder()
                .title("Test title")
                .description("test description")
                .id(12L)
                .releaseYear(2012)
                .build();

    }


    private BookDTO getBookDTO(){

        return BookDTO.builder()
                .title("test title")
                .description("test description")
                .id(12L)
                .releaseYear(2020)
                .build();
    }

}