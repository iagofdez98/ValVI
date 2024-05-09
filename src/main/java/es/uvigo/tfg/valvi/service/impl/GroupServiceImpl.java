package es.uvigo.tfg.valvi.service.impl;

import java.time.LocalDate;
import java.util.List;

import es.uvigo.tfg.valvi.dto.GroupDto;
import es.uvigo.tfg.valvi.entity.Group;
import es.uvigo.tfg.valvi.entity.User;
import es.uvigo.tfg.valvi.mapper.GroupMapper;
import es.uvigo.tfg.valvi.repository.GroupRepository;
import es.uvigo.tfg.valvi.repository.UserRepository;
import es.uvigo.tfg.valvi.service.GroupService;
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
  private UserRepository userRepository;
  
  @Override
  public List<GroupDto> findGroups() {
    List<Group> groups = this.groupRepository.findAll();
    return this.groupMapper.toGroupDtoList(groups);
  }

  @Override
  public GroupDto upsertGroup(GroupDto groupDto) {
    groupDto.setDate(LocalDate.now());
    User user = this.userRepository.findByUsername(groupDto.getUsername());
    Group group = this.groupMapper.toGroup(groupDto);
    group.setUsername(user);
    this.groupRepository.save(group);
    return this.groupMapper.toGroupDto(group);
  }

  @Override
  public Integer deleteGroup(Integer id) {
    this.groupRepository.deleteById(id);
    return id;
  }
}
