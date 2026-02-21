package uz.pdp.springboot_module.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.payload.BaseResponse;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;
import uz.pdp.springboot_module.service.GroupService;
import uz.pdp.springboot_module.utils.Constants;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(GroupController.BASE_URL)
public class GroupController {
    public static final String BASE_URL = Constants.BASE_URL + "/groups";
    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<GroupResponse>> create(@RequestBody @Valid GroupCreator creator) {
        BaseResponse<GroupResponse> response = groupService.create(creator);
        return ResponseEntity.status(response.getSuccess() ? 201 : 400).body(response);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<BaseResponse<GroupResponse>> findById(@PathVariable Long id) {
        BaseResponse<GroupResponse> response = groupService.findById(id);
        return ResponseEntity.status(response.getSuccess() ? 200 : 404).body(response);
    }


    @GetMapping("/findAll")
    public ResponseEntity<BaseResponse<List<GroupResponse>>> findAll() {
        BaseResponse<List<GroupResponse>> response = groupService.findAll();
        return ResponseEntity.status(response.getSuccess() ? 200 : 404).body(response);
    }
}
