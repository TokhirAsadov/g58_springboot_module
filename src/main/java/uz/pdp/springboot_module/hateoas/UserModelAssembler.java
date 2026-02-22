package uz.pdp.springboot_module.hateoas;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import uz.pdp.springboot_module.controller.UserController;
import uz.pdp.springboot_module.entity.User;
import uz.pdp.springboot_module.payload.UserResponse;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<UserResponse, EntityModel<UserResponse>> {

    @Override
    public EntityModel<UserResponse> toModel(UserResponse entity) {
        Link link = linkTo(methodOn(UserController.class).findById(entity.id())).withSelfRel();
        Link deleteById = linkTo(methodOn(UserController.class).deleteById(entity.id())).withRel("delete_by_id");
        Link deleteByIdV2 = linkTo(methodOn(UserController.class).deleteByIdV2(entity.id())).withRel("delete_by_id_v2");
        Link findAll = linkTo(methodOn(UserController.class).findAll()).withRel("find_all");
        return EntityModel.of(entity, link, deleteById, deleteByIdV2, findAll);
    }

    @Override
    public CollectionModel<EntityModel<UserResponse>> toCollectionModel(Iterable<? extends UserResponse> entities) {
        List<UserResponse> users = new ArrayList<>();
        entities.forEach(users::add);

        List<EntityModel<UserResponse>> modelList = users.stream().map(user -> {
            Link link = linkTo(methodOn(UserController.class).findById(user.id())).withRel("find_by_id");
            Link deleteById = linkTo(methodOn(UserController.class).deleteById(user.id())).withRel("delete_by_id");
            Link deleteByIdV2 = linkTo(methodOn(UserController.class).deleteByIdV2(user.id())).withRel("delete_by_id_v2");
            Link findAll = linkTo(methodOn(UserController.class).findAll()).withRel("find_all");
            return EntityModel.of(user, link, deleteById, deleteByIdV2, findAll);
        }).toList();
        Link link = linkTo(methodOn(UserController.class).findAll()).withSelfRel();
        return CollectionModel.of(modelList, link);
    }
}
