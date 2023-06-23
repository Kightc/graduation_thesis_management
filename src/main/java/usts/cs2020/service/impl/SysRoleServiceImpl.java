package usts.cs2020.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cs2020.mapper.SysRoleMapper;
import usts.cs2020.model.system.SysRole;
import usts.cs2020.service.SysRoleService;

/**
 * Description:
 *
 * @Author Kight
 * @Date 2023/6/22 10:16
 * @Version 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements
        SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
}
