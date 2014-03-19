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

package com.rivetlogic.hoveruserinfo.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rivetlogic.hoveruserinfo.service.ClpSerializer;
import com.rivetlogic.hoveruserinfo.service.UserDisplayPreferenceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author juancarrillo
 */
public class UserDisplayPreferenceClp extends BaseModelImpl<UserDisplayPreference>
	implements UserDisplayPreference {
	public UserDisplayPreferenceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserDisplayPreference.class;
	}

	@Override
	public String getModelClassName() {
		return UserDisplayPreference.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _preferenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPreferenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _preferenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("preferenceId", getPreferenceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("addFriend", getAddFriend());
		attributes.put("commonFriendsCount", getCommonFriendsCount());
		attributes.put("commonFriendsImages", getCommonFriendsImages());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("joinDate", getJoinDate());
		attributes.put("lastPostDate", getLastPostDate());
		attributes.put("location", getLocation());
		attributes.put("postsCount", getPostsCount());
		attributes.put("rank", getRank());
		attributes.put("stars", getStars());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long preferenceId = (Long)attributes.get("preferenceId");

		if (preferenceId != null) {
			setPreferenceId(preferenceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Boolean addFriend = (Boolean)attributes.get("addFriend");

		if (addFriend != null) {
			setAddFriend(addFriend);
		}

		Boolean commonFriendsCount = (Boolean)attributes.get(
				"commonFriendsCount");

		if (commonFriendsCount != null) {
			setCommonFriendsCount(commonFriendsCount);
		}

		Boolean commonFriendsImages = (Boolean)attributes.get(
				"commonFriendsImages");

		if (commonFriendsImages != null) {
			setCommonFriendsImages(commonFriendsImages);
		}

		Boolean jobTitle = (Boolean)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		Boolean joinDate = (Boolean)attributes.get("joinDate");

		if (joinDate != null) {
			setJoinDate(joinDate);
		}

		Boolean lastPostDate = (Boolean)attributes.get("lastPostDate");

		if (lastPostDate != null) {
			setLastPostDate(lastPostDate);
		}

		Boolean location = (Boolean)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Boolean postsCount = (Boolean)attributes.get("postsCount");

		if (postsCount != null) {
			setPostsCount(postsCount);
		}

		Boolean rank = (Boolean)attributes.get("rank");

		if (rank != null) {
			setRank(rank);
		}

		Boolean stars = (Boolean)attributes.get("stars");

		if (stars != null) {
			setStars(stars);
		}
	}

	@Override
	public long getPreferenceId() {
		return _preferenceId;
	}

	@Override
	public void setPreferenceId(long preferenceId) {
		_preferenceId = preferenceId;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPreferenceId", long.class);

				method.invoke(_userDisplayPreferenceRemoteModel, preferenceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_userDisplayPreferenceRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAddFriend() {
		return _addFriend;
	}

	@Override
	public boolean isAddFriend() {
		return _addFriend;
	}

	@Override
	public void setAddFriend(boolean addFriend) {
		_addFriend = addFriend;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setAddFriend", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, addFriend);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCommonFriendsCount() {
		return _commonFriendsCount;
	}

	@Override
	public boolean isCommonFriendsCount() {
		return _commonFriendsCount;
	}

	@Override
	public void setCommonFriendsCount(boolean commonFriendsCount) {
		_commonFriendsCount = commonFriendsCount;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCommonFriendsCount",
						boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel,
					commonFriendsCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCommonFriendsImages() {
		return _commonFriendsImages;
	}

	@Override
	public boolean isCommonFriendsImages() {
		return _commonFriendsImages;
	}

	@Override
	public void setCommonFriendsImages(boolean commonFriendsImages) {
		_commonFriendsImages = commonFriendsImages;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCommonFriendsImages",
						boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel,
					commonFriendsImages);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getJobTitle() {
		return _jobTitle;
	}

	@Override
	public boolean isJobTitle() {
		return _jobTitle;
	}

	@Override
	public void setJobTitle(boolean jobTitle) {
		_jobTitle = jobTitle;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getJoinDate() {
		return _joinDate;
	}

	@Override
	public boolean isJoinDate() {
		return _joinDate;
	}

	@Override
	public void setJoinDate(boolean joinDate) {
		_joinDate = joinDate;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setJoinDate", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, joinDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLastPostDate() {
		return _lastPostDate;
	}

	@Override
	public boolean isLastPostDate() {
		return _lastPostDate;
	}

	@Override
	public void setLastPostDate(boolean lastPostDate) {
		_lastPostDate = lastPostDate;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setLastPostDate", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, lastPostDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLocation() {
		return _location;
	}

	@Override
	public boolean isLocation() {
		return _location;
	}

	@Override
	public void setLocation(boolean location) {
		_location = location;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPostsCount() {
		return _postsCount;
	}

	@Override
	public boolean isPostsCount() {
		return _postsCount;
	}

	@Override
	public void setPostsCount(boolean postsCount) {
		_postsCount = postsCount;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPostsCount", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, postsCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRank() {
		return _rank;
	}

	@Override
	public boolean isRank() {
		return _rank;
	}

	@Override
	public void setRank(boolean rank) {
		_rank = rank;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setRank", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, rank);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStars() {
		return _stars;
	}

	@Override
	public boolean isStars() {
		return _stars;
	}

	@Override
	public void setStars(boolean stars) {
		_stars = stars;

		if (_userDisplayPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userDisplayPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setStars", boolean.class);

				method.invoke(_userDisplayPreferenceRemoteModel, stars);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserDisplayPreferenceRemoteModel() {
		return _userDisplayPreferenceRemoteModel;
	}

	public void setUserDisplayPreferenceRemoteModel(
		BaseModel<?> userDisplayPreferenceRemoteModel) {
		_userDisplayPreferenceRemoteModel = userDisplayPreferenceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _userDisplayPreferenceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_userDisplayPreferenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserDisplayPreferenceLocalServiceUtil.addUserDisplayPreference(this);
		}
		else {
			UserDisplayPreferenceLocalServiceUtil.updateUserDisplayPreference(this);
		}
	}

	@Override
	public UserDisplayPreference toEscapedModel() {
		return (UserDisplayPreference)ProxyUtil.newProxyInstance(UserDisplayPreference.class.getClassLoader(),
			new Class[] { UserDisplayPreference.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserDisplayPreferenceClp clone = new UserDisplayPreferenceClp();

		clone.setPreferenceId(getPreferenceId());
		clone.setCompanyId(getCompanyId());
		clone.setAddFriend(getAddFriend());
		clone.setCommonFriendsCount(getCommonFriendsCount());
		clone.setCommonFriendsImages(getCommonFriendsImages());
		clone.setJobTitle(getJobTitle());
		clone.setJoinDate(getJoinDate());
		clone.setLastPostDate(getLastPostDate());
		clone.setLocation(getLocation());
		clone.setPostsCount(getPostsCount());
		clone.setRank(getRank());
		clone.setStars(getStars());

		return clone;
	}

	@Override
	public int compareTo(UserDisplayPreference userDisplayPreference) {
		long primaryKey = userDisplayPreference.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserDisplayPreferenceClp)) {
			return false;
		}

		UserDisplayPreferenceClp userDisplayPreference = (UserDisplayPreferenceClp)obj;

		long primaryKey = userDisplayPreference.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{preferenceId=");
		sb.append(getPreferenceId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", addFriend=");
		sb.append(getAddFriend());
		sb.append(", commonFriendsCount=");
		sb.append(getCommonFriendsCount());
		sb.append(", commonFriendsImages=");
		sb.append(getCommonFriendsImages());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", joinDate=");
		sb.append(getJoinDate());
		sb.append(", lastPostDate=");
		sb.append(getLastPostDate());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", postsCount=");
		sb.append(getPostsCount());
		sb.append(", rank=");
		sb.append(getRank());
		sb.append(", stars=");
		sb.append(getStars());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.hoveruserinfo.model.UserDisplayPreference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>preferenceId</column-name><column-value><![CDATA[");
		sb.append(getPreferenceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addFriend</column-name><column-value><![CDATA[");
		sb.append(getAddFriend());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commonFriendsCount</column-name><column-value><![CDATA[");
		sb.append(getCommonFriendsCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commonFriendsImages</column-name><column-value><![CDATA[");
		sb.append(getCommonFriendsImages());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joinDate</column-name><column-value><![CDATA[");
		sb.append(getJoinDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPostDate</column-name><column-value><![CDATA[");
		sb.append(getLastPostDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postsCount</column-name><column-value><![CDATA[");
		sb.append(getPostsCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rank</column-name><column-value><![CDATA[");
		sb.append(getRank());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stars</column-name><column-value><![CDATA[");
		sb.append(getStars());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _preferenceId;
	private long _companyId;
	private boolean _addFriend;
	private boolean _commonFriendsCount;
	private boolean _commonFriendsImages;
	private boolean _jobTitle;
	private boolean _joinDate;
	private boolean _lastPostDate;
	private boolean _location;
	private boolean _postsCount;
	private boolean _rank;
	private boolean _stars;
	private BaseModel<?> _userDisplayPreferenceRemoteModel;
}