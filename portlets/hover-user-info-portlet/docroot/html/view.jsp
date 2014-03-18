<%--
/**
* Copyright (C) 2005-2014 Rivet Logic Corporation.
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; version 3
* of the License.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor,
* Boston, MA 02110-1301, USA.
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.PortletDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
String currentURL = PortalUtil.getCurrentURL(request);
%>

<portlet:actionURL name="savePreferences" var="savePreferencesURL">
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:actionURL>

<aui:form name="savePreferences_fm" action="<%= savePreferencesURL %>">

	<aui:fieldset label="hui-show-message">
	
		<aui:input name="addFriend" label="hui-add-friend" type="checkbox"/>
	
		<aui:input name="commonFriendsCount" label="hui-common-friends-count" type="checkbox"/>
		
		<aui:input name="commonFriendsImages" label="hui-common-friends-images" type="checkbox"/>
		
		<aui:input name="jobTitle" label="hui-job-title" type="checkbox"/>
		
		<aui:input name="joinDate" label="hui-join-date" type="checkbox"/>
		
		<aui:input name="lastPostDate" label="hui-last-post-date" type="checkbox"/>
		
		<aui:input name="location" label="hui-location" type="checkbox"/>
		
		<aui:input name="postsCount" label="hui-posts-count" type="checkbox"/>
		
		<aui:input name="rank" label="hui-rank" type="checkbox"/>
		
		<aui:input name="stars" label="hui-stars" type="checkbox"/>
		
	</aui:fieldset>
	
	<aui:input name="submit" label="" value='<%= LanguageUtil.get(pageContext, "hui-save") %>' type="submit"/>
		
</aui:form>

