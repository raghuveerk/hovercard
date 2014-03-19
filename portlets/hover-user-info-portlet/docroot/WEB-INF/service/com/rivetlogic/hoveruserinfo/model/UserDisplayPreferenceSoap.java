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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rivetlogic.hoveruserinfo.service.http.UserDisplayPreferenceServiceSoap}.
 *
 * @author juancarrillo
 * @see com.rivetlogic.hoveruserinfo.service.http.UserDisplayPreferenceServiceSoap
 * @generated
 */
public class UserDisplayPreferenceSoap implements Serializable {
	public static UserDisplayPreferenceSoap toSoapModel(
		UserDisplayPreference model) {
		UserDisplayPreferenceSoap soapModel = new UserDisplayPreferenceSoap();

		soapModel.setPreferenceId(model.getPreferenceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAddFriend(model.getAddFriend());
		soapModel.setCommonFriendsCount(model.getCommonFriendsCount());
		soapModel.setCommonFriendsImages(model.getCommonFriendsImages());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setJoinDate(model.getJoinDate());
		soapModel.setLastPostDate(model.getLastPostDate());
		soapModel.setLocation(model.getLocation());
		soapModel.setPostsCount(model.getPostsCount());
		soapModel.setRank(model.getRank());
		soapModel.setStars(model.getStars());

		return soapModel;
	}

	public static UserDisplayPreferenceSoap[] toSoapModels(
		UserDisplayPreference[] models) {
		UserDisplayPreferenceSoap[] soapModels = new UserDisplayPreferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserDisplayPreferenceSoap[][] toSoapModels(
		UserDisplayPreference[][] models) {
		UserDisplayPreferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserDisplayPreferenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserDisplayPreferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserDisplayPreferenceSoap[] toSoapModels(
		List<UserDisplayPreference> models) {
		List<UserDisplayPreferenceSoap> soapModels = new ArrayList<UserDisplayPreferenceSoap>(models.size());

		for (UserDisplayPreference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserDisplayPreferenceSoap[soapModels.size()]);
	}

	public UserDisplayPreferenceSoap() {
	}

	public long getPrimaryKey() {
		return _preferenceId;
	}

	public void setPrimaryKey(long pk) {
		setPreferenceId(pk);
	}

	public long getPreferenceId() {
		return _preferenceId;
	}

	public void setPreferenceId(long preferenceId) {
		_preferenceId = preferenceId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public boolean getAddFriend() {
		return _addFriend;
	}

	public boolean isAddFriend() {
		return _addFriend;
	}

	public void setAddFriend(boolean addFriend) {
		_addFriend = addFriend;
	}

	public boolean getCommonFriendsCount() {
		return _commonFriendsCount;
	}

	public boolean isCommonFriendsCount() {
		return _commonFriendsCount;
	}

	public void setCommonFriendsCount(boolean commonFriendsCount) {
		_commonFriendsCount = commonFriendsCount;
	}

	public boolean getCommonFriendsImages() {
		return _commonFriendsImages;
	}

	public boolean isCommonFriendsImages() {
		return _commonFriendsImages;
	}

	public void setCommonFriendsImages(boolean commonFriendsImages) {
		_commonFriendsImages = commonFriendsImages;
	}

	public boolean getJobTitle() {
		return _jobTitle;
	}

	public boolean isJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(boolean jobTitle) {
		_jobTitle = jobTitle;
	}

	public boolean getJoinDate() {
		return _joinDate;
	}

	public boolean isJoinDate() {
		return _joinDate;
	}

	public void setJoinDate(boolean joinDate) {
		_joinDate = joinDate;
	}

	public boolean getLastPostDate() {
		return _lastPostDate;
	}

	public boolean isLastPostDate() {
		return _lastPostDate;
	}

	public void setLastPostDate(boolean lastPostDate) {
		_lastPostDate = lastPostDate;
	}

	public boolean getLocation() {
		return _location;
	}

	public boolean isLocation() {
		return _location;
	}

	public void setLocation(boolean location) {
		_location = location;
	}

	public boolean getPostsCount() {
		return _postsCount;
	}

	public boolean isPostsCount() {
		return _postsCount;
	}

	public void setPostsCount(boolean postsCount) {
		_postsCount = postsCount;
	}

	public boolean getRank() {
		return _rank;
	}

	public boolean isRank() {
		return _rank;
	}

	public void setRank(boolean rank) {
		_rank = rank;
	}

	public boolean getStars() {
		return _stars;
	}

	public boolean isStars() {
		return _stars;
	}

	public void setStars(boolean stars) {
		_stars = stars;
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
}