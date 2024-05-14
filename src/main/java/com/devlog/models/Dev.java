package com.devlog.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Document
@Getter
@Setter
@ToString
public class Dev {
    @Id
    private String gitId;
    private String accessToken;
    private String refreshToken;
}
