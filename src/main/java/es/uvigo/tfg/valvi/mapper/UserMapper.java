package es.uvigo.tfg.valvi.mapper;

import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface User mapper.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * To user dto user dto.
     *
     * @param user the user
     * @return the user dto
     */
    UserDto toUserDto(User user);

    /**
     * To user user.
     *
     * @param dto the dto
     * @return the user
     */
    @Mapping(source = "role", target = "role", defaultValue = "User")
    User toUser(UserDto dto);
}
