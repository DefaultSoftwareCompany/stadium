package com.dsc.stadium.dto;

import com.dsc.stadium.utils.AuthorityConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Integer id;
    @NotNull
    private String login;
    @NotNull
    @Pattern(regexp = "\\(998\\)\\d{3}-\\d{4}")
    private String phoneNumber;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @Size(min = 6, max = 12)
    private String password;
    private Set<AuthorityConstants> authorities;
}
