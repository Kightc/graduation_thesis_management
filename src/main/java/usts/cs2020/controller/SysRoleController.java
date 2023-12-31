package usts.cs2020.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import usts.cs2020.model.system.SysRole;
import usts.cs2020.model.vo.SysRoleVo;
import usts.cs2020.service.SysRoleService;
import usts.cs2020.utils.Result;

import java.util.List;

/**
 * Description:
 *
 * @Author Kight
 * @Date 2023/6/22 10:53
 * @Version 1.0
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "获取全部角色列表")

    @GetMapping("findAll")
    public Result findAll(){
        List<SysRole> roleList = sysRoleService.list();
        return Result.ok(roleList);
    }
    //条件分页查询
//page 当前页  limit 每页显示记录数
//SysRoleQueryVo 条件对象
    @ApiOperation("条件分页查询")
    @GetMapping("{current}/{size}")
    public Result pageQueryRole(@PathVariable Long current,
                                @PathVariable Long size,
                                SysRoleVo vo) {
        //调用service的方法实现
        //1 创建Page对象，传递分页相关参数
        //page 当前页  limit 每页显示记录数
        Page<SysRole> pageParam = new Page<>(current, size);
        //2 封装条件，判断条件是否为空，不为空进行封装
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        if(vo.getRoleName() != null) {
            String roleName = vo.getRoleName();
            if (!StringUtils.isEmpty(roleName)) {
                //封装 like模糊查询
                wrapper.like(SysRole::getRoleName, roleName);
            }
        }
        //3 调用方法实现
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);
        return Result.ok(pageModel);
    }


    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysRole role = sysRoleService.getById(id);
        return Result.ok(role);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public Result save(@RequestBody @Validated SysRole role) {
        sysRoleService.save(role);
        return Result.ok();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    public Result updateById(@RequestBody SysRole role) {
        sysRoleService.updateById(role);
        return Result.ok();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        sysRoleService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        sysRoleService.removeByIds(idList);
        return Result.ok();
    }
}
