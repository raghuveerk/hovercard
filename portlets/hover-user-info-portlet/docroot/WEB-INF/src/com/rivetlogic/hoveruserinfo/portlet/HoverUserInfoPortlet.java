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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rivetlogic.hoveruserinfo.model.UserDisplayPreference;
import com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceImpl;
import com.rivetlogic.hoveruserinfo.service.UserDisplayPreferenceLocalServiceUtil;
import com.rivetlogic.hoveruserinfo.util.Constants;
import com.rivetlogic.hoveruserinfo.util.WebKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class HoverUserInfoPortlet extends MVCPortlet {

	public void savePreferences(ActionRequest request, ActionResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			UserDisplayPreference preference =
				UserDisplayPreferenceLocalServiceUtil.getUserDisplayPreferenceByCompanyId(themeDisplay.getCompanyId());

			preference.setAddFriend(ParamUtil.getBoolean(request, Constants.ADD_FRIEND));
			preference.setCommonFriendsCount(ParamUtil.getBoolean(request, Constants.COMMON_FRIENDS_COUNT));
			preference.setCommonFriendsImages(ParamUtil.getBoolean(request, Constants.COMMON_FRIENDS_IMAGES));
			preference.setJobTitle(ParamUtil.getBoolean(request, Constants.JOB_TITLE));
			preference.setJoinDate(ParamUtil.getBoolean(request, Constants.JOIN_DATE));
			preference.setLastPostDate(ParamUtil.getBoolean(request, Constants.LAST_POST_DATE));
			preference.setLocation(ParamUtil.getBoolean(request, Constants.LOCATION));
			preference.setPostsCount(ParamUtil.getBoolean(request, Constants.POSTS_COUNT));
			preference.setRank(ParamUtil.getBoolean(request, Constants.RANK));
			preference.setStars(ParamUtil.getBoolean(request, Constants.STARS));

			UserDisplayPreferenceLocalServiceUtil.updateUserDisplayPreference(preference);

		}
		catch (SystemException e) {
			_log.error("error changing user display preferences", e);
			SessionErrors.add(request, "error-changing-preferences");
		}
	}

	public void render(RenderRequest request, RenderResponse response)
		throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		UserDisplayPreference preference = null;
		try {
			preference =
				UserDisplayPreferenceLocalServiceUtil.getUserDisplayPreferenceByCompanyId(themeDisplay.getCompanyId());
		}
		catch (SystemException e) {
			_log.error("error getting user display preferences", e);
		}
		
		if (Validator.isNull(preference)) {
			preference = new UserDisplayPreferenceImpl();
		}
		
		request.setAttribute(WebKeys.USER_DISPLAY_PREFERENCE, preference);
		
		super.render(request, response);
	}

	Log _log = LogFactoryUtil.getLog(HoverUserInfoPortlet.class);
}
