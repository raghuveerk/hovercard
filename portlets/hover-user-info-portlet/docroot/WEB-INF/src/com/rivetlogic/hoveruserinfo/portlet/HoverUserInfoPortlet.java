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

package com.rivetlogic.hoveruserinfo.portlet;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HoverUserInfoPortlet extends MVCPortlet {
	
	public void savePreferences(ActionRequest request, ActionResponse response) {
		
	}
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info( themeDisplay.getPlid() );
		_log.info( themeDisplay.getScopeGroupId() );
		

		super.render(request, response);
	}
	
	Log _log = LogFactoryUtil.getLog(HoverUserInfoPortlet.class);
}
