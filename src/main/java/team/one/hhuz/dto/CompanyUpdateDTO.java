package team.one.hhuz.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompanyUpdateDTO {

    @NotBlank
    private String name;

    private String newName;
    private List<String> email;
    private List<String> phone;
    private String latitude;
    private String longitude;

    private String url;
    private String description;
    private String logoImagePath;


}
