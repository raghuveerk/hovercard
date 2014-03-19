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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.hoveruserinfo.model.UserDisplayPreference;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserDisplayPreference in entity cache.
 *
 * @author juancarrillo
 * @see UserDisplayPreference
 * @generated
 */
public class UserDisplayPreferenceCacheModel implements CacheModel<UserDisplayPreference>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{preferenceId=");
		sb.append(preferenceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", addFriend=");
		sb.append(addFriend);
		sb.append(", commonFriendsCount=");
		sb.append(commonFriendsCount);
		sb.append(", commonFriendsImages=");
		sb.append(commonFriendsImages);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", joinDate=");
		sb.append(joinDate);
		sb.append(", lastPostDate=");
		sb.append(lastPostDate);
		sb.append(", location=");
		sb.append(location);
		sb.append(", postsCount=");
		sb.append(postsCount);
		sb.append(", rank=");
		sb.append(rank);
		sb.append(", stars=");
		sb.append(stars);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserDisplayPreference toEntityModel() {
		UserDisplayPreferenceImpl userDisplayPreferenceImpl = new UserDisplayPreferenceImpl();

		userDisplayPreferenceImpl.setPreferenceId(preferenceId);
		userDisplayPreferenceImpl.setCompanyId(companyId);
		userDisplayPreferenceImpl.setAddFriend(addFriend);
		userDisplayPreferenceImpl.setCommonFriendsCount(commonFriendsCount);
		userDisplayPreferenceImpl.setCommonFriendsImages(commonFriendsImages);
		userDisplayPreferenceImpl.setJobTitle(jobTitle);
		userDisplayPreferenceImpl.setJoinDate(joinDate);
		userDisplayPreferenceImpl.setLastPostDate(lastPostDate);
		userDisplayPreferenceImpl.setLocation(location);
		userDisplayPreferenceImpl.setPostsCount(postsCount);
		userDisplayPreferenceImpl.setRank(rank);
		userDisplayPreferenceImpl.setStars(stars);

		userDisplayPreferenceImpl.resetOriginalValues();

		return userDisplayPreferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		preferenceId = objectInput.readLong();
		companyId = objectInput.readLong();
		addFriend = objectInput.readBoolean();
		commonFriendsCount = objectInput.readBoolean();
		commonFriendsImages = objectInput.readBoolean();
		jobTitle = objectInput.readBoolean();
		joinDate = objectInput.readBoolean();
		lastPostDate = objectInput.readBoolean();
		location = objectInput.readBoolean();
		postsCount = objectInput.readBoolean();
		rank = objectInput.readBoolean();
		stars = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(preferenceId);
		objectOutput.writeLong(companyId);
		objectOutput.writeBoolean(addFriend);
		objectOutput.writeBoolean(commonFriendsCount);
		objectOutput.writeBoolean(commonFriendsImages);
		objectOutput.writeBoolean(jobTitle);
		objectOutput.writeBoolean(joinDate);
		objectOutput.writeBoolean(lastPostDate);
		objectOutput.writeBoolean(location);
		objectOutput.writeBoolean(postsCount);
		objectOutput.writeBoolean(rank);
		objectOutput.writeBoolean(stars);
	}

	public long preferenceId;
	public long companyId;
	public boolean addFriend;
	public boolean commonFriendsCount;
	public boolean commonFriendsImages;
	public boolean jobTitle;
	public boolean joinDate;
	public boolean lastPostDate;
	public boolean location;
	public boolean postsCount;
	public boolean rank;
	public boolean stars;
}