package uz.pdp.springboot_module.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_module.payload.GroupCreator;
import uz.pdp.springboot_module.payload.GroupResponse;
import uz.pdp.springboot_module.service.GroupService;
import uz.pdp.springboot_module.utils.Constants;

@RestController
@RequiredArgsConstructor
@RequestMapping(GroupController.BASE_URL)
public class GroupController {
    public static final String BASE_URL = Constants.BASE_URL + "/groups";
    private final GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<GroupResponse> create(@RequestBody @Valid GroupCreator creator) {
        GroupResponse response = groupService.create(creator);
        return ResponseEntity.status(201).body(response);
    }
}
