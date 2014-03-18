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
	
		<div class="user-pop-up" style="background-color: yellow;">
			
			<!-- custom code -->
			<%
			try {
				List<PortletPreferences> preferences = PortletPreferencesLocalServiceUtil.getPortletPreferences(themeDisplay.getPlid(), "hoveruserinfo_WAR_hoveruserinfoportlet");
				
				for (PortletPreferences preference : preferences) {
					_log.info(preference.getPreferences());
				}
				
			} catch (Exception e) {
				
			}
			BlogsStatsUser statsUser = BlogsStatsUserLocalServiceUtil.getStatsUser(groupId, userId);
			List<Address> addresses = userDisplay.getAddresses();
			%>
			<div class="blogger-post-count">
				<span><liferay-ui:message key="posts" />:</span> <%= statsUser.getEntryCount() %>
			</div>
		
			<div class="blogger-stars">
				<span><liferay-ui:message key="stars" />:</span> <%= statsUser.getRatingsTotalEntries() %>
			</div>
			
			<c:if test="<%= Validator.isNotNull(statsUser.getLastPostDate()) %>">
				<div class="last-post-date">
					<span><liferay-ui:message key="last-post-date" />:</span> <%= dateFormatDate.format(statsUser.getLastPostDate()) %>
				</div>
			</c:if>
			
			<c:if test="<%= !addresses.isEmpty() %>">
				<div class="user-address">
					<span><%= HtmlUtil.escape(addresses.get(0).getCity()) %></span>
					<span><%= HtmlUtil.escape(addresses.get(0).getCountry().getName(themeDisplay.getLocale())) %></span>
				</div>
			</c:if>
			
			<c:if test="<%= Validator.isNotNull(userDisplay.getJobTitle()) %>">
				<div class="user-post-title">
					<span><%= HtmlUtil.escape(userDisplay.getJobTitle()) %></span>
				</div>
			</c:if>
			
			<div class="user-friends">
				<%
				List<User> friends = UserLocalServiceUtil.getSocialUsers(userDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND, 0, FRIEND_IMAGES_COUNT, new UserLoginDateComparator());
				for (User friend : friends) {
					String friendImagePath = friend.getPortraitURL(themeDisplay);
					String friendAlt = HtmlUtil.escapeAttribute(friend.getFullName());
					String friendUrl = friend.getDisplayURL(themeDisplay);
				%>
					<aui:a href="<%= friendUrl %>">
						<span class="user-profile-image">
							<img alt="<%= friendAlt %>" title="<%= HtmlUtil.escape(friend.getFullName())  %>" class="avatar" src="<%= HtmlUtil.escape(friendImagePath) %>" width="65" />
						</span>
						
						<!-- the username could appear when hovering the user avatar -->
					</aui:a>
				<%
				}
				%>
			</div>
		
		</div>
		
		