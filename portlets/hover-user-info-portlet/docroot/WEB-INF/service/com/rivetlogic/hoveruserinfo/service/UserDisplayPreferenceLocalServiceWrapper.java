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

package com.rivetlogic.hoveruserinfo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserDisplayPreferenceLocalService}.
 *
 * @author juancarrillo
 * @see UserDisplayPreferenceLocalService
 * @generated
 */
public class UserDisplayPreferenceLocalServiceWrapper
	implements UserDisplayPreferenceLocalService,
		ServiceWrapper<UserDisplayPreferenceLocalService> {
	public UserDisplayPreferenceLocalServiceWrapper(
		UserDisplayPreferenceLocalService userDisplayPreferenceLocalService) {
		_userDisplayPreferenceLocalService = userDisplayPreferenceLocalService;
	}

	/**
	* Adds the user display preference to the database. Also notifies the appropriate model listeners.
	*
	* @param userDisplayPreference the user display preference
	* @return the user display preference that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference addUserDisplayPreference(
		com.rivetlogic.hoveruserinfo.model.UserDisplayPreference userDisplayPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.addUserDisplayPreference(userDisplayPreference);
	}

	/**
	* Creates a new user display preference with the primary key. Does not add the user display preference to the database.
	*
	* @param preferenceId the primary key for the new user display preference
	* @return the new user display preference
	*/
	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference createUserDisplayPreference(
		long preferenceId) {
		return _userDisplayPreferenceLocalService.createUserDisplayPreference(preferenceId);
	}

	/**
	* Deletes the user display preference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preferenceId the primary key of the user display preference
	* @return the user display preference that was removed
	* @throws PortalException if a user display preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference deleteUserDisplayPreference(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.deleteUserDisplayPreference(preferenceId);
	}

	/**
	* Deletes the user display preference from the database. Also notifies the appropriate model listeners.
	*
	* @param userDisplayPreference the user display preference
	* @return the user display preference that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference deleteUserDisplayPreference(
		com.rivetlogic.hoveruserinfo.model.UserDisplayPreference userDisplayPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.deleteUserDisplayPreference(userDisplayPreference);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userDisplayPreferenceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference fetchUserDisplayPreference(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.fetchUserDisplayPreference(preferenceId);
	}

	/**
	* Returns the user display preference with the primary key.
	*
	* @param preferenceId the primary key of the user display preference
	* @return the user display preference
	* @throws PortalException if a user display preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference getUserDisplayPreference(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.getUserDisplayPreference(preferenceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> getUserDisplayPreferences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.getUserDisplayPreferences(start,
			end);
	}

	/**
	* Returns the number of user display preferences.
	*
	* @return the number of user display preferences
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserDisplayPreferencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.getUserDisplayPreferencesCount();
	}

	/**
	* Updates the user display preference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userDisplayPreference the user display preference
	* @return the user display preference that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference updateUserDisplayPreference(
		com.rivetlogic.hoveruserinfo.model.UserDisplayPreference userDisplayPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.updateUserDisplayPreference(userDisplayPreference);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userDisplayPreferenceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userDisplayPreferenceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userDisplayPreferenceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference getUserDisplayPreferenceByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userDisplayPreferenceLocalService.getUserDisplayPreferenceByCompanyId(companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserDisplayPreferenceLocalService getWrappedUserDisplayPreferenceLocalService() {
		return _userDisplayPreferenceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserDisplayPreferenceLocalService(
		UserDisplayPreferenceLocalService userDisplayPreferenceLocalService) {
		_userDisplayPreferenceLocalService = userDisplayPreferenceLocalService;
	}

	@Override
	public UserDisplayPreferenceLocalService getWrappedService() {
		return _userDisplayPreferenceLocalService;
	}

	@Override
	public void setWrappedService(
		UserDisplayPreferenceLocalService userDisplayPreferenceLocalService) {
		_userDisplayPreferenceLocalService = userDisplayPreferenceLocalService;
	}

	private UserDisplayPreferenceLocalService _userDisplayPreferenceLocalService;
}