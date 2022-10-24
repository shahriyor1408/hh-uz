package com.company.hhuz.handler.errorResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@ToString
public class ApiErrorResponse {
    private String friendlyMessage;
    private String developerMessage;
    private Map<String, Object> errorFields;
    @Builder.Default
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now(Clock.systemUTC()));
    private String requestPath;

}