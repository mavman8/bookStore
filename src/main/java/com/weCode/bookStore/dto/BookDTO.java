package com.weCode.bookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String title;

    private String description;

    private long id;

    private int releaseYear;

}
