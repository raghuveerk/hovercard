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

package com.rivetlogic.hoveruserinfo.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rivetlogic.hoveruserinfo.model.UserDisplayPreference;
import com.rivetlogic.hoveruserinfo.model.UserDisplayPreferenceModel;
import com.rivetlogic.hoveruserinfo.model.UserDisplayPreferenceSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the UserDisplayPreference service. Represents a row in the &quot;rivetlogic_UserDisplayPreference&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rivetlogic.hoveruserinfo.model.UserDisplayPreferenceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserDisplayPreferenceImpl}.
 * </p>
 *
 * @author juancarrillo
 * @see UserDisplayPreferenceImpl
 * @see com.rivetlogic.hoveruserinfo.model.UserDisplayPreference
 * @see com.rivetlogic.hoveruserinfo.model.UserDisplayPreferenceModel
 * @generated
 */
@JSON(strict = true)
public class UserDisplayPreferenceModelImpl extends BaseModelImpl<UserDisplayPreference>
	implements UserDisplayPreferenceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user display preference model instance should use the {@link com.rivetlogic.hoveruserinfo.model.UserDisplayPreference} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_UserDisplayPreference";
	public static final Object[][] TABLE_COLUMNS = {
			{ "preferenceId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "addFriend", Types.BOOLEAN },
			{ "commonFriendsCount", Types.BOOLEAN },
			{ "commonFriendsImages", Types.BOOLEAN },
			{ "jobTitle", Types.BOOLEAN },
			{ "joinDate", Types.BOOLEAN },
			{ "lastPostDate", Types.BOOLEAN },
			{ "location", Types.BOOLEAN },
			{ "postsCount", Types.BOOLEAN },
			{ "rank", Types.BOOLEAN },
			{ "stars", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table rivetlogic_UserDisplayPreference (preferenceId LONG not null primary key,companyId LONG,addFriend BOOLEAN,commonFriendsCount BOOLEAN,commonFriendsImages BOOLEAN,jobTitle BOOLEAN,joinDate BOOLEAN,lastPostDate BOOLEAN,location BOOLEAN,postsCount BOOLEAN,rank BOOLEAN,stars BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_UserDisplayPreference";
	public static final String ORDER_BY_JPQL = " ORDER BY userDisplayPreference.preferenceId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_UserDisplayPreference.preferenceId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.hoveruserinfo.model.UserDisplayPreference"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.hoveruserinfo.model.UserDisplayPreference"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.hoveruserinfo.model.UserDisplayPreference"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long PREFERENCEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserDisplayPreference toModel(
		UserDisplayPreferenceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserDisplayPreference model = new UserDisplayPreferenceImpl();

		model.setPreferenceId(soapModel.getPreferenceId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setAddFriend(soapModel.getAddFriend());
		model.setCommonFriendsCount(soapModel.getCommonFriendsCount());
		model.setCommonFriendsImages(soapModel.getCommonFriendsImages());
		model.setJobTitle(soapModel.getJobTitle());
		model.setJoinDate(soapModel.getJoinDate());
		model.setLastPostDate(soapModel.getLastPostDate());
		model.setLocation(soapModel.getLocation());
		model.setPostsCount(soapModel.getPostsCount());
		model.setRank(soapModel.getRank());
		model.setStars(soapModel.getStars());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserDisplayPreference> toModels(
		UserDisplayPreferenceSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserDisplayPreference> models = new ArrayList<UserDisplayPreference>(soapModels.length);

		for (UserDisplayPreferenceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.hoveruserinfo.model.UserDisplayPreference"));

	public UserDisplayPreferenceModelImpl() {
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
	public Class<?> getModelClass() {
		return UserDisplayPreference.class;
	}

	@Override
	public String getModelClassName() {
		return UserDisplayPreference.class.getName();
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

	@JSON
	@Override
	public long getPreferenceId() {
		return _preferenceId;
	}

	@Override
	public void setPreferenceId(long preferenceId) {
		_preferenceId = preferenceId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	@JSON
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
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			UserDisplayPreference.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserDisplayPreference toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserDisplayPreference)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserDisplayPreferenceImpl userDisplayPreferenceImpl = new UserDisplayPreferenceImpl();

		userDisplayPreferenceImpl.setPreferenceId(getPreferenceId());
		userDisplayPreferenceImpl.setCompanyId(getCompanyId());
		userDisplayPreferenceImpl.setAddFriend(getAddFriend());
		userDisplayPreferenceImpl.setCommonFriendsCount(getCommonFriendsCount());
		userDisplayPreferenceImpl.setCommonFriendsImages(getCommonFriendsImages());
		userDisplayPreferenceImpl.setJobTitle(getJobTitle());
		userDisplayPreferenceImpl.setJoinDate(getJoinDate());
		userDisplayPreferenceImpl.setLastPostDate(getLastPostDate());
		userDisplayPreferenceImpl.setLocation(getLocation());
		userDisplayPreferenceImpl.setPostsCount(getPostsCount());
		userDisplayPreferenceImpl.setRank(getRank());
		userDisplayPreferenceImpl.setStars(getStars());

		userDisplayPreferenceImpl.resetOriginalValues();

		return userDisplayPreferenceImpl;
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

		if (!(obj instanceof UserDisplayPreference)) {
			return false;
		}

		UserDisplayPreference userDisplayPreference = (UserDisplayPreference)obj;

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
	public void resetOriginalValues() {
		UserDisplayPreferenceModelImpl userDisplayPreferenceModelImpl = this;

		userDisplayPreferenceModelImpl._originalCompanyId = userDisplayPreferenceModelImpl._companyId;

		userDisplayPreferenceModelImpl._setOriginalCompanyId = false;

		userDisplayPreferenceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserDisplayPreference> toCacheModel() {
		UserDisplayPreferenceCacheModel userDisplayPreferenceCacheModel = new UserDisplayPreferenceCacheModel();

		userDisplayPreferenceCacheModel.preferenceId = getPreferenceId();

		userDisplayPreferenceCacheModel.companyId = getCompanyId();

		userDisplayPreferenceCacheModel.addFriend = getAddFriend();

		userDisplayPreferenceCacheModel.commonFriendsCount = getCommonFriendsCount();

		userDisplayPreferenceCacheModel.commonFriendsImages = getCommonFriendsImages();

		userDisplayPreferenceCacheModel.jobTitle = getJobTitle();

		userDisplayPreferenceCacheModel.joinDate = getJoinDate();

		userDisplayPreferenceCacheModel.lastPostDate = getLastPostDate();

		userDisplayPreferenceCacheModel.location = getLocation();

		userDisplayPreferenceCacheModel.postsCount = getPostsCount();

		userDisplayPreferenceCacheModel.rank = getRank();

		userDisplayPreferenceCacheModel.stars = getStars();

		return userDisplayPreferenceCacheModel;
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

	private static ClassLoader _classLoader = UserDisplayPreference.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UserDisplayPreference.class
		};
	private long _preferenceId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
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
	private long _columnBitmask;
	private UserDisplayPreference _escapedModel;
}