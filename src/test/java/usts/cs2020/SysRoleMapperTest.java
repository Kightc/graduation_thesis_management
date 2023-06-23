package usts.cs2020;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import usts.cs2020.mapper.SysRoleMapper;
import usts.cs2020.model.system.SysRole;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Description:
 *
 * @Author Kight
 * @Date 2023/6/21 20:46
 * @Version 1.0
 */
@SpringBootTest
public class SysRoleMapperTest {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testSelectList(){
        System.out.println("----------- selectAll method test -----");

        List<SysRole> Roles = sysRoleMapper.selectList(null);
        Roles.forEach(System.out::println);
    }
    @Test
    public void testSelectWrapper(){
        System.out.println("----------- selectWrapper method test -----");

        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysRole::getRoleName, "student");

        List<SysRole> sysRoles = sysRoleMapper.selectList(wrapper);
        System.out.println(sysRoles);
    }
    @Test//增
    public void testInsert(){
        System.out.println("----------- insert method test -----");
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("administrator");
        sysRole.setDescription("管理员角色");
        sysRoleMapper.insert(sysRole);
    }
    @Test
    public void testUpdate(){
        System.out.println("----------- update method test -----");
        SysRole sysRole = new SysRole();
        sysRole.setId(2L);
        sysRole.setRoleName("student");
        sysRole.setDescription("学生角色");
        sysRoleMapper.updateById(sysRole);
    }
    @Test
    public void testDelete(){
        sysRoleMapper.deleteById(1);
    }
    @Test
    public void testDeleteBatchIds(){
        int result = sysRoleMapper.deleteBatchIds(Arrays.asList(1,2));
        System.out.println(result);
    }


}
