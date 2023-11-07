package com.sprint_4.crm.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class OrderRequest {

    @NotNull(message = "client id shouldnt be null")
    @Positive(message = "client id must be positive")
    private Long clientID;
    @NotNull(message = "product id shouldnt be null")
    @Positive(message = "product id must be positive")
    private List<Long> productID;
    @NotNull(message = "quantity shouldnt be null")
    @Positive(message = "quantity must be positive")
    private List<Long> quantity;

}
