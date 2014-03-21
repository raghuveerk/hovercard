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

<%@ include file="/html/taglib/init.jsp" %>

<%@ page import="com.liferay.portal.model.Address" %>
<%@ page import="com.liferay.portal.model.EmailAddress" %>
<%@ page import="com.liferay.portal.model.Phone" %>
<%@ page import="com.liferay.portlet.social.model.SocialRelationConstants" %>
<%@ page import="com.liferay.portal.util.comparator.UserLoginDateComparator" %>

<%
final int FRIEND_IMAGES_COUNT = 5;
				 
User userDisplay = (User)request.getAttribute("liferay-ui:user-display:user");
				 
long companyId = themeDisplay.getCompanyId();
long groupId = themeDisplay.getScopeGroupId();
long userId = userDisplay.getUserId();

String userName = GetterUtil.getString((String)request.getAttribute("liferay-ui:user-display:user-name"));
String url = (String)request.getAttribute("liferay-ui:user-display:url");
int displayStyle = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:user-display:displayStyle"));
Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);

%>