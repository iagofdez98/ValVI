package es.uvigo.tfg.valvi.mapper;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GroupDto;
import es.uvigo.tfg.valvi.entity.Group;
import org.mapstruct.Mapper;

/**
 * The interface Group mapper.
 */
@Mapper(componentModel = "spring")
public interface GroupMapper {

    /**
     * To group dto group dto.
     *
     * @param group the group
     * @return the group dto
     */
    GroupDto toGroupDto(Group group);

    /**
     * To group group.
     *
     * @param dto the dto
     * @return the group
     */
    Group toGroup(GroupDto dto);

    /**
     * To group dto list list.
     *
     * @param groups the groups
     * @return the list
     */
    List<GroupDto> toGroupDtoList(List<Group> groups);
}
