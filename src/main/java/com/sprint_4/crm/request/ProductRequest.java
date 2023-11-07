package com.sprint_4.crm.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductRequest {

    @NotEmpty(message = "O nome do produto é obrigatório.")
    @NotNull(message = "nome shouldnt be empty")
    private String name;
    @NotNull(message = "preço shouldnt be empty")
    @Positive(message = "O preço deve ser um valor positivo.")
    private double price;

}
