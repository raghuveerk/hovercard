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
    <style>
        .user-details{
            display: block; /* ensures it’s invisible until it’s called */
            position: absolute; /* makes the div go into a position that’s absolute to the browser viewing area */
            left: 18%; /* positions the div half way horizontally */
            top: 10%; /* positions the div half way vertically */
            padding: 10px; 
            border: 1px solid #ccc;
            background-color: #ffffff;
            width: 50%;
            z-index: 100; /* makes the div the top layer, so it’ll lay on top of the other content */
            -moz-box-shadow: 1px 3px 3px 1px #ccc;
            -webkit-box-shadow: 1px 3px 3px 1px #ccc;
            box-shadow: 1px 3px 3px 1px #ccc;
        }
    </style>
    <script>
        
    </script>
	<aui:a href="<%= url %>">
		<span class="user-profile-image">
			<img alt="<%= taglibAlt %>" class="avatar" src="<%= HtmlUtil.escape(taglibSrc) %>" width="65" />
		</span>

		<span class="user-name">
			<%= (userDisplay != null) ? HtmlUtil.escape(userDisplay.getFullName()) : HtmlUtil.escape(userName) %>
		</span>
	</aui:a>
	
	<div class="user-details">
	
		<div class="user-pop-up">
			
			<!-- custom code -->
			<%
			MBStatsUser mbStatsUser = MBStatsUserLocalServiceUtil.getStatsUser(groupId, userId);
			int mbMessagesCount = mbStatsUser.getMessageCount();
			BlogsStatsUser blogsStatsUser = BlogsStatsUserLocalServiceUtil.getStatsUser(groupId, userId);
			int blogsEntriesCount = blogsStatsUser.getEntryCount();
			%>
			<div class="posts-count">
				<span><liferay-ui:message key="posts" />:</span> <%= mbMessagesCount + blogsEntriesCount %>
			</div>
		
			<div class="blogger-stars">
				<span><liferay-ui:message key="stars" />:</span> <%= blogsStatsUser.getRatingsTotalEntries() %>
			</div>
			
			<div class="join-date">
				<span><liferay-ui:message key="join-date" />:</span> <%= dateFormatDate.format(userDisplay.getCreateDate()) %>
			</div>
			
			<c:if test="<%= Validator.isNotNull(blogsStatsUser.getLastPostDate()) %>">
				<div class="last-post-date">
					<span><liferay-ui:message key="last-post-date" />:</span> <%= dateFormatDate.format(blogsStatsUser.getLastPostDate()) %>
				</div>
			</c:if>
			
			<%
			List<Address> addresses = userDisplay.getAddresses();
			%>
			<c:if test="<%= !addresses.isEmpty() %>">
				<div class="user-address">
					<span><%= HtmlUtil.escape(addresses.get(0).getCity()) %></span>
					<span><%= HtmlUtil.escape(addresses.get(0).getCountry().getName(themeDisplay.getLocale())) %></span>
				</div>
			</c:if>
			
			<c:if test="<%= Validator.isNotNull(userDisplay.getJobTitle()) %>">
				<div class="user-job-title">
					<span><%= HtmlUtil.escape(userDisplay.getJobTitle()) %></span>
				</div>
			</c:if>
			
			<div class="user-friends">
				<%
				List<User> friends = UserLocalServiceUtil.getSocialUsers(userId, SocialRelationConstants.TYPE_BI_FRIEND, 0, FRIEND_IMAGES_COUNT, new UserLoginDateComparator());
				int friendsCount = UserLocalServiceUtil.getSocialUsersCount(userId, SocialRelationConstants.TYPE_BI_FRIEND);
				%>
				<span>
					<liferay-ui:message key="friends" />: <%= friendsCount %>
				</span>
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
			</div>
		
			<div class="common-user-friends">
				<%
				List<User> commonFriends = UserLocalServiceUtil.getSocialUsers(userId, themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND, 0, FRIEND_IMAGES_COUNT, new UserLoginDateComparator());
				int commonFriendsCount = UserLocalServiceUtil.getSocialUsersCount(userId, themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND);
				%>
				<span>
					<liferay-ui:message key="common-friends" />: <%= commonFriendsCount %>
				</span>
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
			</div>
			
			<%
			String aboutMe = HtmlUtil.escape(ExpandoValueLocalServiceUtil.getData(company.getCompanyId(), User.class.getName(), "SN", "aboutMe", userId, StringPool.BLANK));
			%>

			<c:if test="<%= Validator.isNotNull(aboutMe) %>">
				<div class="user-about">
					<p>
						<span>
							<liferay-ui:message key="about-me" />
						</span>

						<%= aboutMe %>
					</p>
				</div>
			</c:if>
			
		
		</div>
		
		