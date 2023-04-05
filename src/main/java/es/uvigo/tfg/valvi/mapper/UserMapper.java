package es.uvigo.tfg.valvi.mapper;

import es.uvigo.tfg.valvi.dto.UserDto;
import es.uvigo.tfg.valvi.entity.User;
import org.mapstruct.Mapper;

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
    User toUser(UserDto dto);
}
