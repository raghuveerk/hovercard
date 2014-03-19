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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserDisplayPreference}.
 * </p>
 *
 * @author juancarrillo
 * @see UserDisplayPreference
 * @generated
 */
public class UserDisplayPreferenceWrapper implements UserDisplayPreference,
	ModelWrapper<UserDisplayPreference> {
	public UserDisplayPreferenceWrapper(
		UserDisplayPreference userDisplayPreference) {
		_userDisplayPreference = userDisplayPreference;
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

	/**
	* Returns the primary key of this user display preference.
	*
	* @return the primary key of this user display preference
	*/
	@Override
	public long getPrimaryKey() {
		return _userDisplayPreference.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user display preference.
	*
	* @param primaryKey the primary key of this user display preference
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userDisplayPreference.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the preference ID of this user display preference.
	*
	* @return the preference ID of this user display preference
	*/
	@Override
	public long getPreferenceId() {
		return _userDisplayPreference.getPreferenceId();
	}

	/**
	* Sets the preference ID of this user display preference.
	*
	* @param preferenceId the preference ID of this user display preference
	*/
	@Override
	public void setPreferenceId(long preferenceId) {
		_userDisplayPreference.setPreferenceId(preferenceId);
	}

	/**
	* Returns the company ID of this user display preference.
	*
	* @return the company ID of this user display preference
	*/
	@Override
	public long getCompanyId() {
		return _userDisplayPreference.getCompanyId();
	}

	/**
	* Sets the company ID of this user display preference.
	*
	* @param companyId the company ID of this user display preference
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userDisplayPreference.setCompanyId(companyId);
	}

	/**
	* Returns the add friend of this user display preference.
	*
	* @return the add friend of this user display preference
	*/
	@Override
	public boolean getAddFriend() {
		return _userDisplayPreference.getAddFriend();
	}

	/**
	* Returns <code>true</code> if this user display preference is add friend.
	*
	* @return <code>true</code> if this user display preference is add friend; <code>false</code> otherwise
	*/
	@Override
	public boolean isAddFriend() {
		return _userDisplayPreference.isAddFriend();
	}

	/**
	* Sets whether this user display preference is add friend.
	*
	* @param addFriend the add friend of this user display preference
	*/
	@Override
	public void setAddFriend(boolean addFriend) {
		_userDisplayPreference.setAddFriend(addFriend);
	}

	/**
	* Returns the common friends count of this user display preference.
	*
	* @return the common friends count of this user display preference
	*/
	@Override
	public boolean getCommonFriendsCount() {
		return _userDisplayPreference.getCommonFriendsCount();
	}

	/**
	* Returns <code>true</code> if this user display preference is common friends count.
	*
	* @return <code>true</code> if this user display preference is common friends count; <code>false</code> otherwise
	*/
	@Override
	public boolean isCommonFriendsCount() {
		return _userDisplayPreference.isCommonFriendsCount();
	}

	/**
	* Sets whether this user display preference is common friends count.
	*
	* @param commonFriendsCount the common friends count of this user display preference
	*/
	@Override
	public void setCommonFriendsCount(boolean commonFriendsCount) {
		_userDisplayPreference.setCommonFriendsCount(commonFriendsCount);
	}

	/**
	* Returns the common friends images of this user display preference.
	*
	* @return the common friends images of this user display preference
	*/
	@Override
	public boolean getCommonFriendsImages() {
		return _userDisplayPreference.getCommonFriendsImages();
	}

	/**
	* Returns <code>true</code> if this user display preference is common friends images.
	*
	* @return <code>true</code> if this user display preference is common friends images; <code>false</code> otherwise
	*/
	@Override
	public boolean isCommonFriendsImages() {
		return _userDisplayPreference.isCommonFriendsImages();
	}

	/**
	* Sets whether this user display preference is common friends images.
	*
	* @param commonFriendsImages the common friends images of this user display preference
	*/
	@Override
	public void setCommonFriendsImages(boolean commonFriendsImages) {
		_userDisplayPreference.setCommonFriendsImages(commonFriendsImages);
	}

	/**
	* Returns the job title of this user display preference.
	*
	* @return the job title of this user display preference
	*/
	@Override
	public boolean getJobTitle() {
		return _userDisplayPreference.getJobTitle();
	}

	/**
	* Returns <code>true</code> if this user display preference is job title.
	*
	* @return <code>true</code> if this user display preference is job title; <code>false</code> otherwise
	*/
	@Override
	public boolean isJobTitle() {
		return _userDisplayPreference.isJobTitle();
	}

	/**
	* Sets whether this user display preference is job title.
	*
	* @param jobTitle the job title of this user display preference
	*/
	@Override
	public void setJobTitle(boolean jobTitle) {
		_userDisplayPreference.setJobTitle(jobTitle);
	}

	/**
	* Returns the join date of this user display preference.
	*
	* @return the join date of this user display preference
	*/
	@Override
	public boolean getJoinDate() {
		return _userDisplayPreference.getJoinDate();
	}

	/**
	* Returns <code>true</code> if this user display preference is join date.
	*
	* @return <code>true</code> if this user display preference is join date; <code>false</code> otherwise
	*/
	@Override
	public boolean isJoinDate() {
		return _userDisplayPreference.isJoinDate();
	}

	/**
	* Sets whether this user display preference is join date.
	*
	* @param joinDate the join date of this user display preference
	*/
	@Override
	public void setJoinDate(boolean joinDate) {
		_userDisplayPreference.setJoinDate(joinDate);
	}

	/**
	* Returns the last post date of this user display preference.
	*
	* @return the last post date of this user display preference
	*/
	@Override
	public boolean getLastPostDate() {
		return _userDisplayPreference.getLastPostDate();
	}

	/**
	* Returns <code>true</code> if this user display preference is last post date.
	*
	* @return <code>true</code> if this user display preference is last post date; <code>false</code> otherwise
	*/
	@Override
	public boolean isLastPostDate() {
		return _userDisplayPreference.isLastPostDate();
	}

	/**
	* Sets whether this user display preference is last post date.
	*
	* @param lastPostDate the last post date of this user display preference
	*/
	@Override
	public void setLastPostDate(boolean lastPostDate) {
		_userDisplayPreference.setLastPostDate(lastPostDate);
	}

	/**
	* Returns the location of this user display preference.
	*
	* @return the location of this user display preference
	*/
	@Override
	public boolean getLocation() {
		return _userDisplayPreference.getLocation();
	}

	/**
	* Returns <code>true</code> if this user display preference is location.
	*
	* @return <code>true</code> if this user display preference is location; <code>false</code> otherwise
	*/
	@Override
	public boolean isLocation() {
		return _userDisplayPreference.isLocation();
	}

	/**
	* Sets whether this user display preference is location.
	*
	* @param location the location of this user display preference
	*/
	@Override
	public void setLocation(boolean location) {
		_userDisplayPreference.setLocation(location);
	}

	/**
	* Returns the posts count of this user display preference.
	*
	* @return the posts count of this user display preference
	*/
	@Override
	public boolean getPostsCount() {
		return _userDisplayPreference.getPostsCount();
	}

	/**
	* Returns <code>true</code> if this user display preference is posts count.
	*
	* @return <code>true</code> if this user display preference is posts count; <code>false</code> otherwise
	*/
	@Override
	public boolean isPostsCount() {
		return _userDisplayPreference.isPostsCount();
	}

	/**
	* Sets whether this user display preference is posts count.
	*
	* @param postsCount the posts count of this user display preference
	*/
	@Override
	public void setPostsCount(boolean postsCount) {
		_userDisplayPreference.setPostsCount(postsCount);
	}

	/**
	* Returns the rank of this user display preference.
	*
	* @return the rank of this user display preference
	*/
	@Override
	public boolean getRank() {
		return _userDisplayPreference.getRank();
	}

	/**
	* Returns <code>true</code> if this user display preference is rank.
	*
	* @return <code>true</code> if this user display preference is rank; <code>false</code> otherwise
	*/
	@Override
	public boolean isRank() {
		return _userDisplayPreference.isRank();
	}

	/**
	* Sets whether this user display preference is rank.
	*
	* @param rank the rank of this user display preference
	*/
	@Override
	public void setRank(boolean rank) {
		_userDisplayPreference.setRank(rank);
	}

	/**
	* Returns the stars of this user display preference.
	*
	* @return the stars of this user display preference
	*/
	@Override
	public boolean getStars() {
		return _userDisplayPreference.getStars();
	}

	/**
	* Returns <code>true</code> if this user display preference is stars.
	*
	* @return <code>true</code> if this user display preference is stars; <code>false</code> otherwise
	*/
	@Override
	public boolean isStars() {
		return _userDisplayPreference.isStars();
	}

	/**
	* Sets whether this user display preference is stars.
	*
	* @param stars the stars of this user display preference
	*/
	@Override
	public void setStars(boolean stars) {
		_userDisplayPreference.setStars(stars);
	}

	@Override
	public boolean isNew() {
		return _userDisplayPreference.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userDisplayPreference.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userDisplayPreference.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userDisplayPreference.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userDisplayPreference.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userDisplayPreference.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userDisplayPreference.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userDisplayPreference.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userDisplayPreference.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userDisplayPreference.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userDisplayPreference.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserDisplayPreferenceWrapper((UserDisplayPreference)_userDisplayPreference.clone());
	}

	@Override
	public int compareTo(
		com.rivetlogic.hoveruserinfo.model.UserDisplayPreference userDisplayPreference) {
		return _userDisplayPreference.compareTo(userDisplayPreference);
	}

	@Override
	public int hashCode() {
		return _userDisplayPreference.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.hoveruserinfo.model.UserDisplayPreference> toCacheModel() {
		return _userDisplayPreference.toCacheModel();
	}

	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference toEscapedModel() {
		return new UserDisplayPreferenceWrapper(_userDisplayPreference.toEscapedModel());
	}

	@Override
	public com.rivetlogic.hoveruserinfo.model.UserDisplayPreference toUnescapedModel() {
		return new UserDisplayPreferenceWrapper(_userDisplayPreference.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userDisplayPreference.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userDisplayPreference.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userDisplayPreference.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserDisplayPreferenceWrapper)) {
			return false;
		}

		UserDisplayPreferenceWrapper userDisplayPreferenceWrapper = (UserDisplayPreferenceWrapper)obj;

		if (Validator.equals(_userDisplayPreference,
					userDisplayPreferenceWrapper._userDisplayPreference)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserDisplayPreference getWrappedUserDisplayPreference() {
		return _userDisplayPreference;
	}

	@Override
	public UserDisplayPreference getWrappedModel() {
		return _userDisplayPreference;
	}

	@Override
	public void resetOriginalValues() {
		_userDisplayPreference.resetOriginalValues();
	}

	private UserDisplayPreference _userDisplayPreference;
}