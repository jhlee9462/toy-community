package com.example.toycommunity.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserSignUpRequestDto {

    @NotNull
    private String id;
    @NotNull
    private String password;
    @NotNull
    private String name;

}
