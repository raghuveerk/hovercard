<%--
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
--%>

<%@ include file="/html/taglib/ui/user_display/init.jsp" %>

<%
if (Validator.isNull(url) && (userDisplay != null)) {
	url = userDisplay.getDisplayURL(themeDisplay);
}
%>

<div class="taglib-user-display display-style-<%= displayStyle %>">

	<%
	String taglibAlt = (userDisplay != null) ? HtmlUtil.escapeAttribute(userDisplay.getFullName()) : LanguageUtil.get(pageContext, "generic-portrait");

	String taglibSrc = null;

	if (userDisplay != null) {
		taglibSrc = userDisplay.getPortraitURL(themeDisplay);
	}
	else {
		taglibSrc = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, 0);
	}
	%>
	<aui:a href="<%= url %>">
		<span class="user-profile-image">
			<img alt="<%= taglibAlt %>" class="avatar" src="<%= HtmlUtil.escape(taglibSrc) %>" width="65" />
		</span>

		<span class="user-name">
			<%= (userDisplay != null) ? HtmlUtil.escape(userDisplay.getFullName()) : HtmlUtil.escape(userName) %>
		</span>
	</aui:a>
	
	<div class="user-details">
	
		<!-- custom code -->
		
		<div class="user-pop-up">
		
			<%
			boolean showCommonFriends = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_COMMON_FRIENDS, true);
			boolean showEmailAddress = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_EMAIL_ADDRESS, true);
			boolean showFriends = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_FRIENDS, true);
			boolean showPhoneNumber = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_PHONE_NUMBER, true);
			%>
		
			<dl>
				<c:if test="<%= showEmailAddress %>">
					<dt><liferay-ui:message key="email-address"/></dt>
					<dd>
						<%String userEmailAddress = userDisplay.getDisplayEmailAddress(); %>
						<aui:a href="mailto:<%= HtmlUtil.escape(userEmailAddress) %>">
							<span><%= HtmlUtil.escape(userEmailAddress) %></span>
						</aui:a>
					</dd>
				</c:if>
				<c:if test="<%= showPhoneNumber %>">
					<%List<Phone> phones = userDisplay.getPhones();%>
					<c:if test="<%= !phones.isEmpty() %>">
						<dt>
							<c:choose>
								<c:when test="<%= phones.size() > 2 %>">
									<liferay-ui:message key="phone-numbers" />
								</c:when>
								<c:otherwise>
									<liferay-ui:message key="phone-number" />
								</c:otherwise>
							</c:choose>
						</dt>
						<dd>
							<%for (Phone phone : phones) {%>
								<span><%= phone.getNumber() %></span>
							<%}%>
						</dd>
					</c:if>
				</c:if>
				<c:if test="<%= showFriends %>">
					<%
					List<User> friends = UserLocalServiceUtil.getSocialUsers(userId, SocialRelationConstants.TYPE_BI_FRIEND, 0, FRIEND_IMAGES_COUNT, new UserLoginDateComparator());
					int friendsCount = UserLocalServiceUtil.getSocialUsersCount(userId, SocialRelationConstants.TYPE_BI_FRIEND);
					%>
					<dt><liferay-ui:message key="friends" />&nbsp;<%= HtmlUtil.escape("("+friendsCount+")") %></dt>
					<dd>
						<%
						for (User friend : friends) {
							String friendImagePath = friend.getPortraitURL(themeDisplay);
							String friendAlt = HtmlUtil.escapeAttribute(friend.getFullName());
							String friendUrl = friend.getDisplayURL(themeDisplay);
						%>
						<aui:a href="<%= friendUrl %>">
							<span class="user-profile-image">
								<img alt="<%= friendAlt %>" title="<%= HtmlUtil.escape(friend.getFullName())  %>" class="avatar" src="<%= HtmlUtil.escape(friendImagePath) %>" width="65" />
							</span>
						</aui:a>
						<%
						}
						%>
					</dd>
				</c:if>
				<c:if test="<%= showCommonFriends %>">
					<%
					List<User> commonFriends = UserLocalServiceUtil.getSocialUsers(userId, themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND, 0, FRIEND_IMAGES_COUNT, new UserLoginDateComparator());
					int commonFriendsCount = UserLocalServiceUtil.getSocialUsersCount(userId, themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND);
					%>
					<dt><liferay-ui:message key="common-friends" />&nbsp;<%= HtmlUtil.escape("("+commonFriendsCount+")") %></dt>
					<dd>
						<%
						for (User friend : commonFriends) {
							String friendImagePath = friend.getPortraitURL(themeDisplay);
							String friendAlt = HtmlUtil.escapeAttribute(friend.getFullName());
							String friendUrl = friend.getDisplayURL(themeDisplay);
						%>
							<aui:a href="<%= friendUrl %>">
								<span class="user-profile-image">
									<img alt="<%= friendAlt %>" title="<%= HtmlUtil.escape(friend.getFullName())  %>" class="avatar" src="<%= HtmlUtil.escape(friendImagePath) %>" width="65" />
								</span>
								
							</aui:a>
						<%
						}
						%>
					</dd>
				</c:if>
			</dl>
			
		</div>
		
		