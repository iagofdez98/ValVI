package es.uvigo.tfg.valvi.mapper;

import java.util.List;

import es.uvigo.tfg.valvi.dto.DeveloperDto;
import es.uvigo.tfg.valvi.entity.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

/**
 * The interface Developer mapper.
 */
@Mapper(componentModel = "spring")
public interface DeveloperMapper {

    /**
     * To developer dto developer dto.
     *
     * @param developer the developer
     * @return the developer dto
     */
    DeveloperDto toDeveloperDto(Developer developer);

    /**
     * To developer developer.
     *
     * @param dto the dto
     * @return the developer
     */
    @Mapping(source = "id", target = "id", defaultExpression = "java( java.util.UUID.randomUUID() )")
    Developer toDeveloper(DeveloperDto dto);

    /**
     * To developer dto list list.
     *
     * @param developers the developers
     * @return the list
     */
    List<DeveloperDto> toDeveloperDtoList(List<Developer> developers);
}
