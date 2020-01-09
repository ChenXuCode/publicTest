package com.train.security.dao;

import java.util.Collection;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.train.base.dao.BaseDAO;
import com.train.base.page.Page;
import com.train.security.entity.SysUser;
import com.train.util.DateUtil;
import com.train.util.Md5Util;
import com.train.util.RandCodeUtil;

@Repository
@Transactional 
public class ISysUserDAOImpl extends BaseDAO implements ISysUserDAO {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<SysUser> findAllUsers(SysUser user) {
		String condtionSQL = "";
		if (user.getUserName() != null && !"".equals(user.getUserName().trim())) {
			condtionSQL = condtionSQL + " and userName like '%"
					+ user.getUserName() + "%'";
		}
		if (user.getUserNickName() != null
				&& !"".equals(user.getUserNickName().trim())) {
			condtionSQL = condtionSQL + " and userNickName like '%"
					+ user.getUserNickName() + "%'";
		}
		if (user.getUserCode() != null && !"".equals(user.getUserCode().trim())) {
			condtionSQL = condtionSQL + " and userCode like '"
					+ user.getUserCode() + "%'";
		}
		if (user.getUserTel() != null && !"".equals(user.getUserTel().trim())) {
			condtionSQL = condtionSQL + " and userTel like '%"
					+ user.getUserTel() + "%'";
		}
		if (user.getUserStatus() != -1) {
			condtionSQL = condtionSQL + " and userStatus ="
					+ user.getUserStatus();
		}
		if (user.getUserType() != -1) {
			condtionSQL = condtionSQL + " and userType =" + user.getUserType();
		}
		String strSQL = "select * from sys_user where 1=1 " + condtionSQL
				+ " order by userCode";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(SysUser.class));
	}

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	@Override
	public Page<SysUser> findAllUsers(Page<SysUser> page, SysUser user) {
		String condtionSQL = "";
		if (user.getUserName() != null && !"".equals(user.getUserName().trim())) {
			condtionSQL = condtionSQL + " and userName like '%"
					+ user.getUserName() + "%'";
		}
		if (user.getUserNickName() != null && !"".equals(user.getUserNickName().trim())) {
			condtionSQL = condtionSQL + " and userNickName like '%"
					+ user.getUserNickName() + "%'";
		}
		if (user.getUserCode() != null && !"".equals(user.getUserCode().trim())) {
			condtionSQL = condtionSQL + " and userCode like '"
					+ user.getUserCode() + "%'";
		}
		if (user.getUserTel() != null && !"".equals(user.getUserTel().trim())) {
			condtionSQL = condtionSQL + " and userTel like '%"
					+ user.getUserTel() + "%'";
		}
		if (user.getUserStatus() != -2) {
			condtionSQL = condtionSQL + " and userStatus =" + user.getUserStatus();
		}
		if (user.getUserType() != -2) {
			condtionSQL = condtionSQL + " and userType =" + user.getUserType();
		}

		String strSQL = "select * from sys_user where 1=1 " + condtionSQL
				+ " order by userCode";
		String strCountSQL = "select count(*) from sys_user where 1=1 "
				+ condtionSQL;
		
		System.out.println(condtionSQL);
		System.out.println();
		System.out.println(strSQL);
		System.out.println();
		System.out.println(strCountSQL);
		
		page.paginationProcess(this.getJdbcTemplate().queryForObject(strCountSQL,java.lang.Long.class));
		String paginationSQL = page.getPaginationSQL(strSQL);
		System.out.println(paginationSQL);
		Collection<SysUser> list = this.getJdbcTemplate().query(paginationSQL,new BeanPropertyRowMapper(SysUser.class));
		System.out.println("list.size()="+list.size());
		page.setPageResult(list);
		return page;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUser findUserById(Integer uuId) {
		String strSQL = "select * from sys_user where uuId=" + uuId;
		return this.getJdbcTemplate().queryForObject(strSQL,
				new BeanPropertyRowMapper(SysUser.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUser findUserByUserCode(String userCode) {
		String strSQL = "select * from sys_user where userCode='" + userCode
				+ "'";
		return this.getJdbcTemplate().queryForObject(strSQL,
				new BeanPropertyRowMapper(SysUser.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public SysUser findUserByUserCodeOrNickName(String userCodeOrNickName) {
		try {
			String strSQL = "select * from sys_user where (usercode='"
					+ userCodeOrNickName + "' or usernickname='"
					+ userCodeOrNickName + "') and userstatus=0 ";
			return this.getJdbcTemplate().queryForObject(strSQL,
					new BeanPropertyRowMapper(SysUser.class));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void saveUser(SysUser user) {
		String strSQL = "insert into sys_user(uuId,userCode,userNickName,userName,userType,userPwd,userCreateDate,userStatus,userRemark,userTel,userEMail,userSourceCode) values("
				//+ RandCodeUtil.getTimeStr()
				+ user.getUuId()
				+ ",'"
				+ user.getUserCode()
				+ "','"
				+ user.getUserNickName()
				+ "','"
				+ user.getUserName()
				+ "',"
				+ user.getUserType()
				+ ",'"
				+ Md5Util.md5(user.getUserPwd())
				+ "','"
				+ DateUtil.Now()
				+ "',"
				+ user.getUserStatus()
				+ ",'"
				+ user.getUserRemark()
				+ "','"
				+ user.getUserTel()
				+ "','"
				+ user.getUserEMail()
				+ "','"
				+ user.getUserSourceCode() + "')";
		this.getJdbcTemplate().update(strSQL);
	}

	@Override
	public Long findUserMaxCode() {
		String strSQL = "select max(usercode)+1 from sys_user";
		return this.getJdbcTemplate().queryForObject(strSQL, Long.class);
	}

	@Override
	public void updateUser(Integer uuId, SysUser user) {
		String strSQL = "update sys_user set userName='" + user.getUserName()
				+ "',userNickName='" + user.getUserNickName() + "',userType="
				+ user.getUserType() + ",userStatus=" + user.getUserStatus()
				+ ",userRemark='" + user.getUserRemark() + "',userTel='"
				+ user.getUserTel() + "',userEMail='" + user.getUserEMail()
				+ "' where uuId=" + uuId;
		this.getJdbcTemplate().update(strSQL);
	}

	@Override
	public void updateUserPwd(Integer uuId, String userNewPwd) {
		String strSQL = "update sys_user set userPwd='" + userNewPwd
				+ "' where uuId=" + uuId;
		this.getJdbcTemplate().update(strSQL);
	}

	@Override
	public void updateUserPwd(String userCode, String userNewPwd) {
		String strSQL = "update sys_user set userPwd='" + userNewPwd
				+ "' where userCode='" + userCode+"'";
		this.getJdbcTemplate().update(strSQL);	
	}
	
	@Override
	public void deleteUser(String userCode) {
		this.deleteUserRole(userCode);
		String strSQL = "update sys_user set userStatus=1 where userCode=" + userCode;
		this.getJdbcTemplate().update(strSQL);

	}

	
	@Override
	public void deleteUserRole(String userCode) {
		SysUser user = this.findUserByUserCode(userCode);
		String strSQL = "delete from sys_userrole where userUUId="
				+ user.getUuId();
		this.getJdbcTemplate().update(strSQL);
	} 


	@Override
	public void saveUserRole(String userCode, String roleIds) {
		SysUser user = this.findUserByUserCode(userCode);
		String[] arrRole = roleIds.split(",");
		for (String roleId : arrRole) {
			String strSQL = "insert into sys_userrole(userUUId,rolecode) values("
					+ user.getUuId() + "," + roleId + ")";
			this.getJdbcTemplate().update(strSQL);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<SysUser> findUserByRole(String roleValue) {
		String strSQL = "select * from sys_user where uuid in(select useruuid from sys_userrole where rolecode in(select rolecode from sys_role where rolename='"
				+ roleValue + "'))";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(SysUser.class));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<SysUser> findAllUsers() {
		String strSQL = "select * from sys_user where userstatus=0 order by userCode";
		return this.getJdbcTemplate().query(strSQL,
				new BeanPropertyRowMapper(SysUser.class));
	}

	@Override
	public boolean invalidPwd(String userCode, String userPwd) {
		String strSQL = "select count(*) from sys_user where userCode='"+userCode+"' and userPwd='"+Md5Util.md5(userPwd)+"'";
		int count = this.getJdbcTemplate().queryForObject(strSQL,Integer.class);
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public Integer findUserMaxUuid() {
		String strSQL = "select max(uuid)+1 from sys_user";
		return this.getJdbcTemplate().queryForObject(strSQL, Integer.class);
	}
}
