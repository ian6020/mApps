package com.mapps.services.base;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionSystemException;

import com.mapps.dao.base.OrganizationDAO;
import com.mapps.dao.base.UserDAO;
import com.mapps.exception.ApplicationException;
import com.mapps.exception.ServiceException;
import com.mapps.models.base.Organization;
import com.mapps.models.base.User;
import com.mapps.utilities.Code;
import com.mapps.utilities.Status;

/**
 * Abstract base class for all services.
 *
 */
public abstract class BaseService
{
	@Autowired
	protected OrganizationDAO traderDao;
	
	@Autowired
	protected UserDAO userDao;
	
	public abstract long getCount();
	
	protected Organization getTrader(String name) throws ServiceException {
		Organization trader = traderDao.findByName(name);
		if(trader == null)
			throw new ServiceException(Status.FAILED, Code.NOT_FOUND);
		return trader;
	}
	
	protected User getUser(String username, Organization trader) throws ServiceException {
		User user = userDao.findByUsernameAndOrganization(username, trader);
		if(user == null)
			throw new ServiceException(Status.FAILED, Code.NOT_FOUND);
		return user;
	}
	
	/**
	 * 
	 * @param entity Object Trader class
	 * @param user LoginUser Trader class
	 * @throws ServiceException if Trader.name are not equal
	 */
	protected void handleOrganizationMatch(Organization entity, String name)
			throws ServiceException {
		
		if( !entity.getName().equals(name) )
			throw new ServiceException(Status.ERROR, Code.INVALID);
	}
	/**
	 * Creates an enclosing {@link ServiceException} for the specified {@link Exception} or
	 * propagates it directly if the specified {@link Exception} is an instance of 
	 * {@link ServiceException}. 
	 * 
	 * @param ex The {@link Exception} to handle
	 * @throws ServiceException The {@link ServiceException}
	 */
	protected void handleException(Exception ex) throws ServiceException, ApplicationException {
		
		/*if(ex instanceof FraudException) {
			FraudException fe = (FraudException) ex;
			String alert = "[ALERT]" + fe.getFraudUser().getUsername()
					+ " tried to " + fe.getDescription()
					+ " around " + fe.getFraudCommitDt().toString();
			traderDao.createHistory(fe.getTrader().getId(),
					fe.getFraudUser().getUsername(), alert);
			throw new ApplicationException(Status.FRAUD);
		}
		else */
		if (ex instanceof ServiceException) {
			throw (ServiceException) ex;
		}
		else if( ex instanceof ConstraintViolationException) {
			ConstraintViolationException cv = (ConstraintViolationException) ex;
			Set<ConstraintViolation<?>> violations = cv.getConstraintViolations();
			if(violations.iterator().hasNext())
				throw new ServiceException(Status.ERROR, Code.VOILATION);
			else throw new ApplicationException(Status.ERROR);
		}
		else if( ex instanceof TransactionSystemException) {
			/**
			 * For unique keys define in Entity. (Trader.name OR User.username)
			 * */
			throw new ServiceException(Status.FAILED, Code.INVALID);
		}
		else {
			ex.printStackTrace();
			ApplicationException up = new ApplicationException(Status.UNKNOWN);
			throw up;
		}
	}
}
