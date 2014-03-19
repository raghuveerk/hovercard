/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.hoveruserinfo.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.hoveruserinfo.model.UserDisplayPreference;

import java.util.List;

/**
 * The persistence utility for the user display preference service. This utility wraps {@link UserDisplayPreferencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see UserDisplayPreferencePersistence
 * @see UserDisplayPreferencePersistenceImpl
 * @generated
 */
public class UserDisplayPreferenceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserDisplayPreference userDisplayPreference) {
		getPersistence().clearCache(userDisplayPreference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserDisplayPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserDisplayPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserDisplayPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserDisplayPreference update(
		UserDisplayPreference userDisplayPreference) throws SystemException {
		return getPersistence().update(userDisplayPreference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserDisplayPreference update(
		UserDisplayPreference userDisplayPreference,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userDisplayPreference, serviceContext);
	}

	/**
	* Returns all the user display preferences where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the user display preferences where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of user display preferences
	* @param end the upper bound of the range of user display preferences (not inclusive)
	* @return the range of matching user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the user display preferences where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of user display preferences
	* @param end the upper bound of the range of user display preferences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first user display preference in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user display preference
	* @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a matching user display preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first user display preference in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user display preference, or <code>null</code> if a matching user display preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last user display preference in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user display preference
	* @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a matching user display preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last user display preference in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user display preference, or <code>null</code> if a matching user display preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the user display preferences before and after the current user display preference in the ordered set where companyId = &#63;.
	*
	* @param preferenceId the primary key of the current user display preference
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user display preference
	* @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference[] findByCompanyId_PrevAndNext(
		long preferenceId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(preferenceId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the user display preferences where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of user display preferences where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Caches the user display preference in the entity cache if it is enabled.
	*
	* @param userDisplayPreference the user display preference
	*/
	public static void cacheResult(
		com.rivetlogic.hoveruserinfo.model.UserDisplayPreference userDisplayPreference) {
		getPersistence().cacheResult(userDisplayPreference);
	}

	/**
	* Caches the user display preferences in the entity cache if it is enabled.
	*
	* @param userDisplayPreferences the user display preferences
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> userDisplayPreferences) {
		getPersistence().cacheResult(userDisplayPreferences);
	}

	/**
	* Creates a new user display preference with the primary key. Does not add the user display preference to the database.
	*
	* @param preferenceId the primary key for the new user display preference
	* @return the new user display preference
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference create(
		long preferenceId) {
		return getPersistence().create(preferenceId);
	}

	/**
	* Removes the user display preference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preferenceId the primary key of the user display preference
	* @return the user display preference that was removed
	* @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference remove(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException {
		return getPersistence().remove(preferenceId);
	}

	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference updateImpl(
		com.rivetlogic.hoveruserinfo.model.UserDisplayPreference userDisplayPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userDisplayPreference);
	}

	/**
	* Returns the user display preference with the primary key or throws a {@link com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException} if it could not be found.
	*
	* @param preferenceId the primary key of the user display preference
	* @return the user display preference
	* @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference findByPrimaryKey(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException {
		return getPersistence().findByPrimaryKey(preferenceId);
	}

	/**
	* Returns the user display preference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param preferenceId the primary key of the user display preference
	* @return the user display preference, or <code>null</code> if a user display preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.hoveruserinfo.model.UserDisplayPreference fetchByPrimaryKey(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(preferenceId);
	}

	/**
	* Returns all the user display preferences.
	*
	* @return the user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user display preferences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user display preferences
	* @param end the upper bound of the range of user display preferences (not inclusive)
	* @return the range of user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user display preferences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user display preferences
	* @param end the upper bound of the range of user display preferences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user display preferences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user display preferences.
	*
	* @return the number of user display preferences
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserDisplayPreferencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserDisplayPreferencePersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.hoveruserinfo.service.ClpSerializer.getServletContextName(),
					UserDisplayPreferencePersistence.class.getName());

			ReferenceRegistry.registerReference(UserDisplayPreferenceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserDisplayPreferencePersistence persistence) {
	}

	private static UserDisplayPreferencePersistence _persistence;
}