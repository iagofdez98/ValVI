package es.uvigo.tfg.valvi.dto;

import es.uvigo.tfg.valvi.auth.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * The type User dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDto {

    @NonNull
    private String username;

    @NonNull
    private String password;

    private String name;

    private String image;

    private Role role;
}
