package uz.pdp.springboot_module.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.pdp.springboot_module.entity.AuthRole;
import uz.pdp.springboot_module.entity.AuthUser;
import uz.pdp.springboot_module.repository.AuthPermissionRepository;
import uz.pdp.springboot_module.repository.AuthRoleRepository;
import uz.pdp.springboot_module.repository.AuthUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthUserRepository authUserRepository;
    private final AuthRoleRepository authRoleRepository;
    private final AuthPermissionRepository authPermissionRepository;

    public CustomUserDetailsService(AuthUserRepository authUserRepository, AuthRoleRepository authRoleRepository, AuthPermissionRepository authPermissionRepository) {
        this.authUserRepository = authUserRepository;
        this.authRoleRepository = authRoleRepository;
        this.authPermissionRepository = authPermissionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));

        var roles = authRoleRepository.findAuthRolesByUserId(authUser.getId());
        for (AuthRole role : roles) {
            var permissions = authPermissionRepository.findAuthPermissionsByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        authUser.setRoles(roles);

        return new CustomUserDetails(authUser);
    }

}
