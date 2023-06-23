package usts.cs2020;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.cs2020.model.system.SysRole;
import usts.cs2020.service.SysRoleService;

import java.util.List;

/**
 * Description:
 *
 * @Author Kight
 * @Date 2023/6/22 10:23
 * @Version 1.0
 */

@SpringBootTest
public class SysRoleServiceTest {
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void testSelectList(){
        System.out.println("------------------------------");
        List<SysRole> sysRoles = sysRoleService.list();
        sysRoles.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("administrator");
        sysRole.setDescription("角色管理员");

        boolean result = sysRoleService.save(sysRole);
        System.out.println(result); //影响的行数
        System.out.println(sysRole); //id自动回填
    }
    @Test
    public void testUpdateById(){
        SysRole sysRole = new SysRole();
        sysRole.setId(4L);
        sysRole.setDescription("管理员角色");

        boolean result = sysRoleService.updateById(sysRole);
        System.out.println(result);

    }

    @Test
    public void testDeleteById(){
        boolean result = sysRoleService.removeById(2L);
        System.out.println(result);
    }
    @Test
    public void testSelect1(){
        LambdaQueryWrapper<SysRole> queryWrapper  =new LambdaQueryWrapper<>();
        queryWrapper.ge(SysRole::getId,2L);
        List<SysRole> sysRoles = sysRoleService.list(queryWrapper);
        System.out.println(sysRoles);
    }


}
