package com.smart24x7.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smart24x7.bean.GetPastRosterDetails;
import com.smart24x7.bean.GetShiftsOfMobile;
import com.smart24x7.bean.User;
import com.smart24x7.common.SqlQuery;
import com.smart24x7.config.DbConfig;
import com.smart24x7.exception.ExceptionMessages;
import com.smart24x7.utils.FetchDataFromResultSet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository implements IUserRepository {

	@Autowired
	private DbConfig dbConfig;
	
	Connection con = null;
	CallableStatement cs = null;

	@Override
	public GetShiftsOfMobile getShiftDataByOid(Integer depId, Integer oid, String mobile, int week, int month, int year) {
		try {
			con = dbConfig.getDbConnection();
			cs = con.prepareCall(SqlQuery.PROC_GET_SHIFTSOF_MOBILE_NO_FOR_SCHEDULE);
			cs.setString(1, mobile);
			cs.setInt(2, week);
			cs.setInt(3, month);
			cs.setInt(4, year);
			cs.setInt(5, depId);
			cs.setInt(6, oid);
			var result = cs.executeQuery();
			return FetchDataFromResultSet.getShiftsOfMobile(result,cs);
		} catch (SQLException e) {
			log.error(ExceptionMessages.ERROR_IN_SQL_DB);
		} finally {
			try {
				if (con != null) {
					con.close();
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public User getUserByMobile(@NotNull String mobile) {
		try {
			con = dbConfig.getDbConnection();
			cs = con.prepareCall(SqlQuery.GET_USER_FROM_MOBILE);
			cs.setString(1, mobile);
			var result = cs.executeQuery();
			return FetchDataFromResultSet.getUserByMobile(result);
		} catch (SQLException e) {
			log.error(ExceptionMessages.ERROR_IN_SQL_DB);
		} finally {
			try{
				if (con != null) {
					con.close();
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<GetPastRosterDetails> getRosterDetails(String fromDate, String toDate, String mobile) {
		try {
			con = dbConfig.getDbConnection();
			cs = con.prepareCall(SqlQuery.GET_PAST_ROSTER_DETAILS_BY_MOBILE);
			cs.setString(1, fromDate);
			cs.setString(2, toDate);
			cs.setString(3, mobile);
			var result = cs.executeQuery();
			return FetchDataFromResultSet.getRosterDetails(result);
		} catch (SQLException e) {
			log.error(ExceptionMessages.ERROR_IN_SQL_DB);
		} finally {
			try {
				if (con != null) {
					con.close();
					cs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
		
	}

}
