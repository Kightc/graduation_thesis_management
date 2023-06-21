package usts.cs2020.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @Author Kight
 * @Date 2023/6/21 16:20
 * @Version 1.0
 */
@Data
public class BaseEntity implements Serializable {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
    private Map<String, Object> param = new HashMap<>();

}
