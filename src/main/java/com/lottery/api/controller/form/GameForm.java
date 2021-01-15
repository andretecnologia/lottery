package com.lottery.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameForm {

    @NotBlank(message = "{field.name.not.be.empty}")
    @Schema(example = "Peter", required = true)
    private String name;

    @Schema(example = "peter@gmail.com", required = true)
    @NotBlank(message = "{field.email.not.be.empty}")
    @Email(message = "{email.should.be.valid}")
    private String email;
}
