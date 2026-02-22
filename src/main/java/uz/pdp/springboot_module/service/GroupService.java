package uz.pdp.springboot_module.service;

import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.group.GetGroupFullInfo;
import uz.pdp.springboot_module.payload.group.GroupCreator;
import uz.pdp.springboot_module.payload.group.GroupResponse;

import java.util.List;

public interface GroupService {
    BaseResponse<GroupResponse> create(GroupCreator creator);

    BaseResponse<GroupResponse> findById(Long id);

    BaseResponse<List<GroupResponse>> findAll();

    BaseResponse<GetGroupFullInfo> getGroupFullInfo(Long id);

    BaseResponse<GroupResponse> update(Long id, GroupCreator creator);
}
