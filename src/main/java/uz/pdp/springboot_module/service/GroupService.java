package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;

public interface GroupService {
    GroupResponse create(GroupCreator creator);
}
