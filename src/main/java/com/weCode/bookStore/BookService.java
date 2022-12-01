package com.weCode.bookStore;



import com.weCode.bookStore.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getBooks();

}
