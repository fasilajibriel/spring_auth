package com.elevateuet.springauth.infrastructure.seed;

import com.elevateuet.springauth.domain.model.*;
import com.elevateuet.springauth.domain.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataSeeder {
    @Bean
    CommandLineRunner loadData(UserRepository users, RoleRepository roles,
                               AccessScopeRepository scopes, ActionPermissionRepository perms,
                               PasswordEncoder encoder) {
        return args -> {
            if (roles.findAll().isEmpty()) {
                AccessScope rolesTab = new AccessScope();
                rolesTab.setName("roles_tab");
                rolesTab = scopes.save(rolesTab);

                AccessScope roleDetail = new AccessScope();
                roleDetail.setName("role_detail");
                roleDetail = scopes.save(roleDetail);

                AccessScope rolePerm = new AccessScope();
                rolePerm.setName("role_permissions");
                rolePerm = scopes.save(rolePerm);

                ActionPermission viewRoles = new ActionPermission();
                viewRoles.setName("view_roles");
                viewRoles = perms.save(viewRoles);
                ActionPermission createRoles = new ActionPermission();
                createRoles.setName("create_roles");
                createRoles = perms.save(createRoles);
                ActionPermission editRoles = new ActionPermission();
                editRoles.setName("edit_roles");
                editRoles = perms.save(editRoles);
                ActionPermission deleteRoles = new ActionPermission();
                deleteRoles.setName("delete_roles");
                deleteRoles = perms.save(deleteRoles);
                ActionPermission viewDetail = new ActionPermission();
                viewDetail.setName("view_role_detail");
                viewDetail = perms.save(viewDetail);
                ActionPermission editRolePerm = new ActionPermission();
                editRolePerm.setName("edit_role_permissions");
                editRolePerm = perms.save(editRolePerm);
                ActionPermission viewRolePerm = new ActionPermission();
                viewRolePerm.setName("view_role_permissions");
                viewRolePerm = perms.save(viewRolePerm);

                Role admin = new Role();
                admin.setName("ADMIN");
                admin.getScopes().addAll(List.of(rolesTab, roleDetail, rolePerm));
                admin.getPermissions().addAll(List.of(viewRoles, createRoles, editRoles, deleteRoles, viewDetail, editRolePerm, viewRolePerm));
                roles.save(admin);

                User user = new User();
                user.setEmail("admin@example.com");
                user.setPassword(encoder.encode("password"));
                user.getRoles().add(admin);
                users.save(user);
            }
        };
    }
}
