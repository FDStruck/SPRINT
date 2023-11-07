package com.sprint_4.crm.request;

import com.sprint_4.crm.model.Order;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ClientRequest {


    @NotNull(message = "O cliente nome é obrigatório.")
    private String clientName;

    @Valid
    private List<Order> orders = new ArrayList<>();
}
