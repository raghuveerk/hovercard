<%--
/**
 * Copyright (C) 2014 Rivet Logic Corporation. All rights reserved.
 */
 
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
	
		<%
		boolean showCommonFriends = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_COMMON_FRIENDS, GetterUtil.getBoolean(PropsUtil.get(HOVER_USER_INFO_COMMON_FRIENDS)));
		boolean showEmailAddress = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_EMAIL_ADDRESS, GetterUtil.getBoolean(PropsUtil.get(HOVER_USER_INFO_EMAIL_ADDRESS)));
		boolean showFriends = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_FRIENDS, GetterUtil.getBoolean(PropsUtil.get(HOVER_USER_INFO_FRIENDS)));
		boolean showPhoneNumber = PrefsPropsUtil.getBoolean(companyId, HOVER_USER_INFO_PHONE_NUMBER, GetterUtil.getBoolean(PropsUtil.get(HOVER_USER_INFO_PHONE_NUMBER)));
		final int FRIEND_IMAGES_COUNT = GetterUtil.getInteger(PropsUtil.get(HOVER_USER_INFO_IMAGES_COUNT));
		boolean showPopUp = GetterUtil.getBoolean(PropsUtil.get(HOVER_USER_INFO_SHOW));
		
		if (showPopUp && !showCommonFriends && !showEmailAddress && !showFriends && !showPhoneNumber) {
			showPopUp = false;
		}
		%>
		<c:if test="<%= showPopUp %>">
		
			<div class="user-pop-up">
			
				<dl>
					<c:if test="<%= showEmailAddress %>">
						<%List<EmailAddress> emails = userDisplay.getEmailAddresses();%>
						<c:if test="<%= !emails.isEmpty() %>">
							<dt><liferay-ui:message key="email-address"/></dt>
							<dd>
								<%for (EmailAddress email : emails) { %>
									<c:if test="<%= email.isPrimary() %>">
										<aui:a href="mailto:<%= HtmlUtil.escape(email.getAddress()) %>">
											<span><%= HtmlUtil.escape(email.getAddress()) %></span>
										</aui:a>
									</c:if>
								<%}%>
							</dd>
						</c:if>
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
									<c:if test="<%= phone.isPrimary() %>">
										<span><%= phone.getNumber() %> <%= phone.getExtension() %> <%= LanguageUtil.get(pageContext, phone.getType().getName()) %></span>
									</c:if>
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
						<c:choose>
							<c:when test="<%= friendsCount > 0 %>">
								<dd class="friends">
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
									<div class="clearfix"></div>
								</dd>
							</c:when>
							<c:otherwise>
								<dd><liferay-ui:message key="no-friends"/></dd>
							</c:otherwise>
						</c:choose>
					</c:if>
					
					<c:if test="<%= showCommonFriends && themeDisplay.getUserId() != userId %>">
						<%
						List<User> commonFriends = UserLocalServiceUtil.getSocialUsers(userId, themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND, 0, FRIEND_IMAGES_COUNT, new UserLoginDateComparator());
						int commonFriendsCount = UserLocalServiceUtil.getSocialUsersCount(userId, themeDisplay.getUserId(), SocialRelationConstants.TYPE_BI_FRIEND);
						%>
						<dt><liferay-ui:message key="common-friends" />&nbsp;<%= HtmlUtil.escape("("+commonFriendsCount+")") %></dt>
						<c:choose>
							<c:when test="<%= commonFriendsCount > 0 %>">
								<dd class="common-friends">
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
							</c:when>
							<c:otherwise>
								<dd><liferay-ui:message key="no-common-friends" /></dd>
							</c:otherwise>
						</c:choose>
						<div class="clearfix"></div>
					</c:if>
				</dl>
			</div>
			
		</c:if>
<style>
		/* Skin */

.taglib-user-display {
	a .user-name {
		text-decoration: underline;
	}

	.user-name {
		font-size: 1.1em;
		font-weight: bold;
	}
	
}


.user-pop-up dl{
    margin-bottom:5px;
    margin-top:5px
}

.user-pop-up {
    display: none;
    position: absolute; 
    padding: 15px; 
    border: 1px solid #ccc;
    background-color: #ffffff;
    width: 35%;
    z-index: 100;
    -moz-box-shadow: 1px 3px 3px 1px #ccc;
    -webkit-box-shadow: 1px 3px 3px 1px #ccc;
    box-shadow: 1px 3px 3px 1px #ccc;
}

.user-pop-up .user-profile-image{
    float:left;
}

.user-pop-up .user-profile-image > img{
    width: 46px;
    height: 46px;
    margin-right:3px;
}

.user-pop-up .clearfix {
    clear: both;
    display: block;
}
/* bottom */
.user-pop-up-bottom{
    left: 7%;
    top: 99%;  
}
.user-pop-up-bottom:before, div:after {
    content: "";
    position: absolute;
    border-left: 10px solid transparent;
    border-right: 10px solid transparent;
    left: 8%;
    margin-left: -10px;
}
 
.user-pop-up-bottom:before {
    border-bottom: 10px solid rgba(0, 0, 0, 0.5);
    top: -11px;
}
 
.user-pop-up-bottom:after{
    border-bottom: 10px solid #FFF;
    top: -10px;
    z-index: 1;
}
/* Top */
.user-pop-up-top{
    left: 7%;
    top: -282%; 
}
.user-pop-up-top:before, div:after {
    content: "";
    position: absolute;
    border-left: 10px solid transparent;
    border-right: 10px solid transparent;
    left: 8%;
    margin-left: -10px;
}
 
.user-pop-up-top:before {
    border-top: 10px solid rgba(0, 0, 0, 0.5);
    top: 246px;
}
 
.user-pop-up-top:after{
    border-top: 10px solid #FFF;
    top: 245px;
    z-index: 1;
}

</style>
<aui:script>  
        (function(){        
		    HTMLElement.prototype.removeClass = function(remove) {
                var newClassName = "";
                var i;
                var classes = this.className.split(" ");
                for(i = 0; i < classes.length; i++) {
                    if(classes[i] !== remove) {
                        newClassName += classes[i] + " ";
                    }
                }
                this.className = newClassName;
            }
		    
		    var comments = document.getElementsByClassName("taglib-user-display display-style-2");
		    comments + document.getElementsByClassName("taglib-user-display display-style-1"); 
		    for (var i in comments){
                comment = comments[i];
		        comment.onmouseover = function(event){
		            commentElement=this.getElementsByClassName("user-pop-up")[0];
		            commentElement.style.display="block";
console.log((commentElement.getBoundingClientRect().top+commentElement.offsetHeight+10) + " > "+ 630);		            if((commentElement.getBoundingClientRect().top+commentElement.offsetHeight+10)>630){
		                commentElement.removeClass("user-pop-up-top");
		                commentElement.removeClass("user-pop-up-bottom");
		                commentElement.className += " user-pop-up-top";
		            }else{
		                commentElement.removeClass("user-pop-up-top");
		                commentElement.removeClass("user-pop-up-bottom");
		                commentElement.className += " user-pop-up-bottom";
		            }
		        }
		        comment.onmouseout = function(event){
		            this.getElementsByClassName("user-pop-up")[0].style.display="none";
		            this.getElementsByClassName("user-pop-up")[0].removeClass("user-pop-up-top");
		            this.getElementsByClassName("user-pop-up")[0].removeClass("user-pop-up-bottom");
		        }
		    }
     })();
</aui:script>