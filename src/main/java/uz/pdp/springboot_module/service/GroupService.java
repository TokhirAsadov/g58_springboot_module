package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;

import java.util.List;

public interface GroupService {
    BaseResponse<GroupResponse> create(GroupCreator creator);

    BaseResponse<GroupResponse> findById(Long id);

    BaseResponse<List<GroupResponse>> findAll();
}
