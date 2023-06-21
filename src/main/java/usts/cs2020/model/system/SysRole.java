package usts.cs2020.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import usts.cs2020.model.base.BaseEntity;

/**
 * Description:
 *
 * @Author Kight
 * @Date 2023/6/21 17:24
 * @Version 1.0
 */
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {
    @TableField("role_name")
    private String roleName;

    @TableField("description")
    private String description;

}
