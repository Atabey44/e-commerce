package com.atabey.eticaret.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {

        private String mail;
        private String firstName;
        private String lastName;
        private String middleName;
        private String postCode;
    }

