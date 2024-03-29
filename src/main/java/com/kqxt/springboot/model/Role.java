package com.kqxt.springboot.model;

import org.hibernate.validator.constraints.Length;

import java.util.Objects;

public class Role implements java.io.Serializable {
    private Integer id;
    @Length(min = 2, max = 30, message = "角色英文名长度必须在 {min} - {max} 之间")
    private String name;//角色名称，采用spring security的命名规则
    @Length(min = 2, max = 20, message = "角色中文名长度必须在 {min} - {max} 之间")
    private String nameZH;//角色中文名称
    private Integer level;//角色级别
    private String description;//角色说明
    private Boolean enabled;//是否启用
    private Boolean defaultRole;//是否为默认角色，方便用户创建时的选择，如果是，则在创建账户时默认选择（也可自行取消）
    //非数据库字段
    private Integer adminNumber;//该角色对应的账户数量
    private Integer purviewNumber;//该角色对应的权限数量

    public Role() {
    }

    public Role(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZH() {
        return nameZH;
    }

    public void setNameZH(String nameZH) {
        this.nameZH = nameZH;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(Boolean defaultRole) {
        this.defaultRole = defaultRole;
    }

    public Integer getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(Integer adminNumber) {
        this.adminNumber = adminNumber;
    }

    public Integer getPurviewNumber() {
        return purviewNumber;
    }

    public void setPurviewNumber(Integer purviewNumber) {
        this.purviewNumber = purviewNumber;
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass())return false;
        Role role=(Role) o;
        return Objects.equals(id,role.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
