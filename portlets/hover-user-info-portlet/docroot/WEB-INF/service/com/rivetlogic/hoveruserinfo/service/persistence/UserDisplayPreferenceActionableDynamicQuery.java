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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.rivetlogic.hoveruserinfo.model.UserDisplayPreference;
import com.rivetlogic.hoveruserinfo.service.UserDisplayPreferenceLocalServiceUtil;

/**
 * @author juancarrillo
 * @generated
 */
public abstract class UserDisplayPreferenceActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public UserDisplayPreferenceActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(UserDisplayPreferenceLocalServiceUtil.getService());
		setClass(UserDisplayPreference.class);

		setClassLoader(com.rivetlogic.hoveruserinfo.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("preferenceId");
	}
}