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

package com.rivetlogic.hoveruserinfo.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.rivetlogic.hoveruserinfo.model.UserDisplayPreference;
import com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceImpl;
import com.rivetlogic.hoveruserinfo.service.base.UserDisplayPreferenceLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the user display preference local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.hoveruserinfo.service.UserDisplayPreferenceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author juancarrillo
 * @see com.rivetlogic.hoveruserinfo.service.base.UserDisplayPreferenceLocalServiceBaseImpl
 * @see com.rivetlogic.hoveruserinfo.service.UserDisplayPreferenceLocalServiceUtil
 */
public class UserDisplayPreferenceLocalServiceImpl
	extends UserDisplayPreferenceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.hoveruserinfo.service.UserDisplayPreferenceLocalServiceUtil} to access the user display preference local service.
	 */
public static final int FIRST_ELEMENT = 0;
	
	public UserDisplayPreference getUserDisplayPreferenceByCompanyId(long companyId) 
			throws SystemException {
		List<UserDisplayPreference> preferences = userDisplayPreferencePersistence.findByCompanyId(companyId);
		
		if (preferences.isEmpty()) {
			UserDisplayPreference preference = userDisplayPreferencePersistence.create(counterLocalService.increment(UserDisplayPreference.class.getName()));
			UserDisplayPreference preferenceToReturn = new UserDisplayPreferenceImpl(true);
			preferenceToReturn.setPreferenceId(preference.getPreferenceId());
			preferenceToReturn.setPrimaryKey(preference.getPrimaryKey());
			preferenceToReturn.setCompanyId(companyId);
			preferenceToReturn.setNew(true);
			
			userDisplayPreferencePersistence.update(preferenceToReturn);
			
			return preferenceToReturn;
			
		} else {
			
			return preferences.get(FIRST_ELEMENT);
		}
	}
}
