package com.zving.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @AUTHOR Administrator
 * @TIME 2021/10/7 17:20
 * @VERSION 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {

    @TableId(type= IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}