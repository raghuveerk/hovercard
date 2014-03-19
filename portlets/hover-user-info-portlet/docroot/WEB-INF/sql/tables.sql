create table rivetlogic_UserDisplayPreference (
	preferenceId LONG not null primary key,
	companyId LONG,
	addFriend BOOLEAN,
	commonFriendsCount BOOLEAN,
	commonFriendsImages BOOLEAN,
	jobTitle BOOLEAN,
	joinDate BOOLEAN,
	lastPostDate BOOLEAN,
	location BOOLEAN,
	postsCount BOOLEAN,
	rank BOOLEAN,
	stars BOOLEAN
);