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
<%@ page import="com.liferay.portal.theme.PortletDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>

<%@ page import="com.rivetlogic.hoveruserinfo.model.UserDisplayPreference"%>
<%@ page import="com.rivetlogic.hoveruserinfo.util.WebKeys" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<liferay-ui:error key="error-changing-preferences" message="error-changing-preferences"/>

<%
String currentURL = PortalUtil.getCurrentURL(request);
UserDisplayPreference userDisplayPreference = (UserDisplayPreference) request.getAttribute(WebKeys.USER_DISPLAY_PREFERENCE);
%>

<portlet:actionURL name="savePreferences" var="savePreferencesURL">
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:actionURL>

<aui:form name="savePreferences_fm" action="<%= savePreferencesURL %>">

	<aui:fieldset label="select-user-display">
	
		<aui:model-context bean="<%= userDisplayPreference %>" model="<%= UserDisplayPreference.class %>"/>
	
		<aui:input name="addFriend" label="add-friend" />
	
		<aui:input name="commonFriendsCount" label="common-friends-count" />
		
		<aui:input name="commonFriendsImages" label="common-friends-images" />
		
		<aui:input name="jobTitle" label="job-title" />
		
		<aui:input name="joinDate" label="join-date" />
		
		<aui:input name="lastPostDate" label="last-post-date" />
		
		<aui:input name="location" label="location" />
		
		<aui:input name="postsCount" label="posts-count" />
		
		<aui:input name="rank" label="rank" />
		
		<aui:input name="stars" label="stars" />
		
	</aui:fieldset>
	
	<aui:input name="submit" label="" value='<%= LanguageUtil.get(pageContext, "save") %>' type="submit"/>
		
</aui:form>

