package com.train.security.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.train.base.page.Page;
import com.train.security.dao.ISysRoleDAO;
import com.train.security.entity.SysRole;

@Service
@Transactional
public class ISysRoleServiceImpl implements ISysRoleService {
	@Autowired
	private ISysRoleDAO sysRoleDAO;

	@Override
	public Collection<SysRole> findAllRoleByUserUUID(Integer userUUID) {
		return sysRoleDAO.findAllRoleByUserUUID(userUUID);
	}

	@Override
	public Page<SysRole> findAllSysRoles(Page<SysRole> page) {
		return sysRoleDAO.findAllSysRoles(page);
	}

	@Override
	
	public Page<SysRole> findAllByMutiConditon(Page<SysRole> page, SysRole role) {
		return sysRoleDAO.findAllByMutiConditon(page, role);
	}

	@Override
	public SysRole findSysRoleById(String roleId) {
		return sysRoleDAO.findSysRoleById(roleId);
	}

	@Override
	public Collection<SysRole> findAllSysRole() {
		return sysRoleDAO.findAllSysRole();
	}

	@Override
	public void saveSysRole(SysRole role) {
		sysRoleDAO.saveSysRole(role);
	}

	@Override
	public void updateSysRole(SysRole role) {
		sysRoleDAO.updateSysRole(role);
	}

	@Override
	public void deleteSysRole(String roleId) {
		sysRoleDAO.deleteSysRole(roleId);
	}

	@Override
	public Long findMaxRoleId() {
		return sysRoleDAO.findMaxRoleId();
	}

	@Override
	public void updateRoleMenus(String roleId, String menuIds) {
		sysRoleDAO.updateRoleMenus(roleId, menuIds);
	}

	@Override
	public Collection<SysRole> findAllRoles() {
		return sysRoleDAO.findAllRoles();
	}
}
