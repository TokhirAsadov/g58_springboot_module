package uz.pdp.springboot_module.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;
import uz.pdp.springboot_module.repository.GroupRepository;
import uz.pdp.springboot_module.service.GroupService;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;


    @Override
    public GroupResponse create(GroupCreator creator) {
        return null;
    }
}
