package es.uvigo.tfg.valvi.service.impl;

import java.util.List;

import es.uvigo.tfg.valvi.dto.GroupDto;
import es.uvigo.tfg.valvi.entity.Group;
import es.uvigo.tfg.valvi.entity.Videogame;
import es.uvigo.tfg.valvi.mapper.GroupMapper;
import es.uvigo.tfg.valvi.repository.GroupRepository;
import es.uvigo.tfg.valvi.repository.VideogameRepository;
import es.uvigo.tfg.valvi.service.GroupService;
import javax.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * The type Group service.
 */
@Service
@Validated
@RequiredArgsConstructor
@Slf4j
public class GroupServiceImpl implements GroupService {

  @NonNull
  private GroupRepository groupRepository;

  @NonNull
  private GroupMapper groupMapper;
  
  @NonNull
  private VideogameRepository videogameRepository;
  
  @Override
  public List<GroupDto> findGroups(String username, Integer videogameId) {
    Videogame videogame = this.videogameRepository.findById(videogameId).orElseThrow(() -> new EntityNotFoundException("Requested document/s have not been found"));
    List<Group> groups = this.groupRepository.findGroupsByUsernameAndVideogamesContaining(username, videogame);   
    
    return this.groupMapper.toGroupDtoList(groups);
  }

  @Override
  public GroupDto upsertGroup(GroupDto groupDto) {
    Group group = this.groupRepository.save(this.groupMapper.toGroup(groupDto));
    
    return this.groupMapper.toGroupDto(group);
  }

  @Override
  public Integer deleteGroup(Integer id) {
    this.groupRepository.deleteById(id);
    return id;
  }
}
