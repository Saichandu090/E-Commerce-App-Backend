package com.chandu.e_commerce.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResponseDTO
{
    private boolean result;
    private String message;
    private List<?> data;
}
