package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.Group;
import uz.pdp.springboot_module.exceptions.DataNotFoundException;
import uz.pdp.springboot_module.exceptions.GroupNameAlreadyExistsException;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;
import uz.pdp.springboot_module.repository.GroupRepository;
import uz.pdp.springboot_module.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;


    @Override
    public BaseResponse<GroupResponse> create(GroupCreator creator) {
        Boolean bool = groupRepository.existsByName(creator.name());
        if (bool) {
            throw new GroupNameAlreadyExistsException("Group with name '" + creator.name() + "' already exists");
        }
        else {
            Group group = new Group();
            group.setName(creator.name());
            group.setLevel(creator.level());
            Group save = groupRepository.save(group);
            return new BaseResponse<>(new GroupResponse(
                    save.getId(),
                    save.getName(),
                    save.getLevel()
            ));
        }

    }

    @Override
    public BaseResponse<GroupResponse> findById(Long id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()){
            Group group = optionalGroup.get();
            GroupResponse groupResponse = new GroupResponse(
                    group.getId(),
                    group.getName(),
                    group.getLevel()
            );
            return new BaseResponse<>(groupResponse);
        }
        else {
            throw new DataNotFoundException("Group with id '" + id + "' not found");
        }
    }

    @Override
    public BaseResponse<List<GroupResponse>> findAll() {
        List<GroupResponse> groupResponses = groupRepository.findAll().stream().map(group -> new GroupResponse(
                group.getId(),
                group.getName(),
                group.getLevel()
        )).toList();
        return new BaseResponse<>(groupResponses);
    }
}
