package lpm.project.lpm_v_1_2.Services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class UtilisateurServiceResponse<T> {
    private String status;
    private T data;
}
