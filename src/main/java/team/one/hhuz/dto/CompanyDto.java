package team.one.hhuz.dto;

import lombok.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Setter
@Getter
public class CompanyDto implements Serializable {
    private String name;
    private String logoImagePath;

    private List<String> phone;

    private List<String> email;


    private String latitude;
    private String longitude;
    private String url;
    private String description;

    private String createdBy;
    private String createdAt;

}
