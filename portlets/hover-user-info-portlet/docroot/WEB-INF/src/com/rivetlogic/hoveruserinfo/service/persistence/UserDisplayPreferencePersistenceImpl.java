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

package com.rivetlogic.hoveruserinfo.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException;
import com.rivetlogic.hoveruserinfo.model.UserDisplayPreference;
import com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceImpl;
import com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user display preference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author juancarrillo
 * @see UserDisplayPreferencePersistence
 * @see UserDisplayPreferenceUtil
 * @generated
 */
public class UserDisplayPreferencePersistenceImpl extends BasePersistenceImpl<UserDisplayPreference>
	implements UserDisplayPreferencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserDisplayPreferenceUtil} to access the user display preference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserDisplayPreferenceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserDisplayPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserDisplayPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserDisplayPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceModelImpl.FINDER_CACHE_ENABLED,
			UserDisplayPreferenceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			UserDisplayPreferenceModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user display preferences where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDisplayPreference> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the user display preferences where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user display preferences
	 * @param end the upper bound of the range of user display preferences (not inclusive)
	 * @return the range of matching user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDisplayPreference> findByCompanyId(long companyId,
		int start, int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user display preferences where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user display preferences
	 * @param end the upper bound of the range of user display preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDisplayPreference> findByCompanyId(long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<UserDisplayPreference> list = (List<UserDisplayPreference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserDisplayPreference userDisplayPreference : list) {
				if ((companyId != userDisplayPreference.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USERDISPLAYPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserDisplayPreferenceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<UserDisplayPreference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserDisplayPreference>(list);
				}
				else {
					list = (List<UserDisplayPreference>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user display preference in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user display preference
	 * @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a matching user display preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserDisplayPreferenceException, SystemException {
		UserDisplayPreference userDisplayPreference = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (userDisplayPreference != null) {
			return userDisplayPreference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserDisplayPreferenceException(msg.toString());
	}

	/**
	 * Returns the first user display preference in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user display preference, or <code>null</code> if a matching user display preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserDisplayPreference> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user display preference in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user display preference
	 * @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a matching user display preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchUserDisplayPreferenceException, SystemException {
		UserDisplayPreference userDisplayPreference = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (userDisplayPreference != null) {
			return userDisplayPreference;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserDisplayPreferenceException(msg.toString());
	}

	/**
	 * Returns the last user display preference in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user display preference, or <code>null</code> if a matching user display preference could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<UserDisplayPreference> list = findByCompanyId(companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user display preferences before and after the current user display preference in the ordered set where companyId = &#63;.
	 *
	 * @param preferenceId the primary key of the current user display preference
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user display preference
	 * @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference[] findByCompanyId_PrevAndNext(
		long preferenceId, long companyId, OrderByComparator orderByComparator)
		throws NoSuchUserDisplayPreferenceException, SystemException {
		UserDisplayPreference userDisplayPreference = findByPrimaryKey(preferenceId);

		Session session = null;

		try {
			session = openSession();

			UserDisplayPreference[] array = new UserDisplayPreferenceImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session,
					userDisplayPreference, companyId, orderByComparator, true);

			array[1] = userDisplayPreference;

			array[2] = getByCompanyId_PrevAndNext(session,
					userDisplayPreference, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserDisplayPreference getByCompanyId_PrevAndNext(
		Session session, UserDisplayPreference userDisplayPreference,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERDISPLAYPREFERENCE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(UserDisplayPreferenceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userDisplayPreference);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserDisplayPreference> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user display preferences where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (UserDisplayPreference userDisplayPreference : findByCompanyId(
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userDisplayPreference);
		}
	}

	/**
	 * Returns the number of user display preferences where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERDISPLAYPREFERENCE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "userDisplayPreference.companyId = ?";

	public UserDisplayPreferencePersistenceImpl() {
		setModelClass(UserDisplayPreference.class);
	}

	/**
	 * Caches the user display preference in the entity cache if it is enabled.
	 *
	 * @param userDisplayPreference the user display preference
	 */
	@Override
	public void cacheResult(UserDisplayPreference userDisplayPreference) {
		EntityCacheUtil.putResult(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceImpl.class,
			userDisplayPreference.getPrimaryKey(), userDisplayPreference);

		userDisplayPreference.resetOriginalValues();
	}

	/**
	 * Caches the user display preferences in the entity cache if it is enabled.
	 *
	 * @param userDisplayPreferences the user display preferences
	 */
	@Override
	public void cacheResult(List<UserDisplayPreference> userDisplayPreferences) {
		for (UserDisplayPreference userDisplayPreference : userDisplayPreferences) {
			if (EntityCacheUtil.getResult(
						UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
						UserDisplayPreferenceImpl.class,
						userDisplayPreference.getPrimaryKey()) == null) {
				cacheResult(userDisplayPreference);
			}
			else {
				userDisplayPreference.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user display preferences.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserDisplayPreferenceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserDisplayPreferenceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user display preference.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserDisplayPreference userDisplayPreference) {
		EntityCacheUtil.removeResult(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceImpl.class,
			userDisplayPreference.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserDisplayPreference> userDisplayPreferences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserDisplayPreference userDisplayPreference : userDisplayPreferences) {
			EntityCacheUtil.removeResult(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
				UserDisplayPreferenceImpl.class,
				userDisplayPreference.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user display preference with the primary key. Does not add the user display preference to the database.
	 *
	 * @param preferenceId the primary key for the new user display preference
	 * @return the new user display preference
	 */
	@Override
	public UserDisplayPreference create(long preferenceId) {
		UserDisplayPreference userDisplayPreference = new UserDisplayPreferenceImpl();

		userDisplayPreference.setNew(true);
		userDisplayPreference.setPrimaryKey(preferenceId);

		return userDisplayPreference;
	}

	/**
	 * Removes the user display preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param preferenceId the primary key of the user display preference
	 * @return the user display preference that was removed
	 * @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference remove(long preferenceId)
		throws NoSuchUserDisplayPreferenceException, SystemException {
		return remove((Serializable)preferenceId);
	}

	/**
	 * Removes the user display preference with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user display preference
	 * @return the user display preference that was removed
	 * @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference remove(Serializable primaryKey)
		throws NoSuchUserDisplayPreferenceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserDisplayPreference userDisplayPreference = (UserDisplayPreference)session.get(UserDisplayPreferenceImpl.class,
					primaryKey);

			if (userDisplayPreference == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserDisplayPreferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userDisplayPreference);
		}
		catch (NoSuchUserDisplayPreferenceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserDisplayPreference removeImpl(
		UserDisplayPreference userDisplayPreference) throws SystemException {
		userDisplayPreference = toUnwrappedModel(userDisplayPreference);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userDisplayPreference)) {
				userDisplayPreference = (UserDisplayPreference)session.get(UserDisplayPreferenceImpl.class,
						userDisplayPreference.getPrimaryKeyObj());
			}

			if (userDisplayPreference != null) {
				session.delete(userDisplayPreference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userDisplayPreference != null) {
			clearCache(userDisplayPreference);
		}

		return userDisplayPreference;
	}

	@Override
	public UserDisplayPreference updateImpl(
		com.rivetlogic.hoveruserinfo.model.UserDisplayPreference userDisplayPreference)
		throws SystemException {
		userDisplayPreference = toUnwrappedModel(userDisplayPreference);

		boolean isNew = userDisplayPreference.isNew();

		UserDisplayPreferenceModelImpl userDisplayPreferenceModelImpl = (UserDisplayPreferenceModelImpl)userDisplayPreference;

		Session session = null;

		try {
			session = openSession();

			if (userDisplayPreference.isNew()) {
				session.save(userDisplayPreference);

				userDisplayPreference.setNew(false);
			}
			else {
				session.merge(userDisplayPreference);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserDisplayPreferenceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userDisplayPreferenceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userDisplayPreferenceModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] {
						userDisplayPreferenceModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
			UserDisplayPreferenceImpl.class,
			userDisplayPreference.getPrimaryKey(), userDisplayPreference);

		return userDisplayPreference;
	}

	protected UserDisplayPreference toUnwrappedModel(
		UserDisplayPreference userDisplayPreference) {
		if (userDisplayPreference instanceof UserDisplayPreferenceImpl) {
			return userDisplayPreference;
		}

		UserDisplayPreferenceImpl userDisplayPreferenceImpl = new UserDisplayPreferenceImpl();

		userDisplayPreferenceImpl.setNew(userDisplayPreference.isNew());
		userDisplayPreferenceImpl.setPrimaryKey(userDisplayPreference.getPrimaryKey());

		userDisplayPreferenceImpl.setPreferenceId(userDisplayPreference.getPreferenceId());
		userDisplayPreferenceImpl.setCompanyId(userDisplayPreference.getCompanyId());
		userDisplayPreferenceImpl.setAddFriend(userDisplayPreference.isAddFriend());
		userDisplayPreferenceImpl.setCommonFriendsCount(userDisplayPreference.isCommonFriendsCount());
		userDisplayPreferenceImpl.setCommonFriendsImages(userDisplayPreference.isCommonFriendsImages());
		userDisplayPreferenceImpl.setJobTitle(userDisplayPreference.isJobTitle());
		userDisplayPreferenceImpl.setJoinDate(userDisplayPreference.isJoinDate());
		userDisplayPreferenceImpl.setLastPostDate(userDisplayPreference.isLastPostDate());
		userDisplayPreferenceImpl.setLocation(userDisplayPreference.isLocation());
		userDisplayPreferenceImpl.setPostsCount(userDisplayPreference.isPostsCount());
		userDisplayPreferenceImpl.setRank(userDisplayPreference.isRank());
		userDisplayPreferenceImpl.setStars(userDisplayPreference.isStars());

		return userDisplayPreferenceImpl;
	}

	/**
	 * Returns the user display preference with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user display preference
	 * @return the user display preference
	 * @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserDisplayPreferenceException, SystemException {
		UserDisplayPreference userDisplayPreference = fetchByPrimaryKey(primaryKey);

		if (userDisplayPreference == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserDisplayPreferenceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userDisplayPreference;
	}

	/**
	 * Returns the user display preference with the primary key or throws a {@link com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException} if it could not be found.
	 *
	 * @param preferenceId the primary key of the user display preference
	 * @return the user display preference
	 * @throws com.rivetlogic.hoveruserinfo.NoSuchUserDisplayPreferenceException if a user display preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference findByPrimaryKey(long preferenceId)
		throws NoSuchUserDisplayPreferenceException, SystemException {
		return findByPrimaryKey((Serializable)preferenceId);
	}

	/**
	 * Returns the user display preference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user display preference
	 * @return the user display preference, or <code>null</code> if a user display preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserDisplayPreference userDisplayPreference = (UserDisplayPreference)EntityCacheUtil.getResult(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
				UserDisplayPreferenceImpl.class, primaryKey);

		if (userDisplayPreference == _nullUserDisplayPreference) {
			return null;
		}

		if (userDisplayPreference == null) {
			Session session = null;

			try {
				session = openSession();

				userDisplayPreference = (UserDisplayPreference)session.get(UserDisplayPreferenceImpl.class,
						primaryKey);

				if (userDisplayPreference != null) {
					cacheResult(userDisplayPreference);
				}
				else {
					EntityCacheUtil.putResult(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
						UserDisplayPreferenceImpl.class, primaryKey,
						_nullUserDisplayPreference);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserDisplayPreferenceModelImpl.ENTITY_CACHE_ENABLED,
					UserDisplayPreferenceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userDisplayPreference;
	}

	/**
	 * Returns the user display preference with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param preferenceId the primary key of the user display preference
	 * @return the user display preference, or <code>null</code> if a user display preference with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserDisplayPreference fetchByPrimaryKey(long preferenceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)preferenceId);
	}

	/**
	 * Returns all the user display preferences.
	 *
	 * @return the user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDisplayPreference> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user display preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user display preferences
	 * @param end the upper bound of the range of user display preferences (not inclusive)
	 * @return the range of user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDisplayPreference> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user display preferences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.hoveruserinfo.model.impl.UserDisplayPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user display preferences
	 * @param end the upper bound of the range of user display preferences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserDisplayPreference> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<UserDisplayPreference> list = (List<UserDisplayPreference>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERDISPLAYPREFERENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERDISPLAYPREFERENCE;

				if (pagination) {
					sql = sql.concat(UserDisplayPreferenceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserDisplayPreference>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserDisplayPreference>(list);
				}
				else {
					list = (List<UserDisplayPreference>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user display preferences from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserDisplayPreference userDisplayPreference : findAll()) {
			remove(userDisplayPreference);
		}
	}

	/**
	 * Returns the number of user display preferences.
	 *
	 * @return the number of user display preferences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERDISPLAYPREFERENCE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the user display preference persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.hoveruserinfo.model.UserDisplayPreference")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserDisplayPreference>> listenersList = new ArrayList<ModelListener<UserDisplayPreference>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserDisplayPreference>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(UserDisplayPreferenceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERDISPLAYPREFERENCE = "SELECT userDisplayPreference FROM UserDisplayPreference userDisplayPreference";
	private static final String _SQL_SELECT_USERDISPLAYPREFERENCE_WHERE = "SELECT userDisplayPreference FROM UserDisplayPreference userDisplayPreference WHERE ";
	private static final String _SQL_COUNT_USERDISPLAYPREFERENCE = "SELECT COUNT(userDisplayPreference) FROM UserDisplayPreference userDisplayPreference";
	private static final String _SQL_COUNT_USERDISPLAYPREFERENCE_WHERE = "SELECT COUNT(userDisplayPreference) FROM UserDisplayPreference userDisplayPreference WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userDisplayPreference.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserDisplayPreference exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserDisplayPreference exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserDisplayPreferencePersistenceImpl.class);
	private static UserDisplayPreference _nullUserDisplayPreference = new UserDisplayPreferenceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserDisplayPreference> toCacheModel() {
				return _nullUserDisplayPreferenceCacheModel;
			}
		};

	private static CacheModel<UserDisplayPreference> _nullUserDisplayPreferenceCacheModel =
		new CacheModel<UserDisplayPreference>() {
			@Override
			public UserDisplayPreference toEntityModel() {
				return _nullUserDisplayPreference;
			}
		};
}