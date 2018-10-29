
package com.am.innovations.builder.controller;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Owner implements Serializable
{

    private String login;
    private Integer id;
    private String nodeId;
    private String avatarUrl;
    private String gravatarId;
    private String url;
    private String htmlUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String starredUrl;
    private String subscriptionsUrl;
    private String organizationsUrl;
    private String reposUrl;
    private String eventsUrl;
    private String receivedEventsUrl;
    private String type;
    private Boolean siteAdmin;
    private final static long serialVersionUID = 4177948137975980653L;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("login", login).append("id", id).append("nodeId", nodeId).append("avatarUrl", avatarUrl).append("gravatarId", gravatarId).append("url", url).append("htmlUrl", htmlUrl).append("followersUrl", followersUrl).append("followingUrl", followingUrl).append("gistsUrl", gistsUrl).append("starredUrl", starredUrl).append("subscriptionsUrl", subscriptionsUrl).append("organizationsUrl", organizationsUrl).append("reposUrl", reposUrl).append("eventsUrl", eventsUrl).append("receivedEventsUrl", receivedEventsUrl).append("type", type).append("siteAdmin", siteAdmin).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eventsUrl).append(siteAdmin).append(gistsUrl).append(type).append(gravatarId).append(subscriptionsUrl).append(url).append(followersUrl).append(id).append(reposUrl).append(htmlUrl).append(nodeId).append(receivedEventsUrl).append(avatarUrl).append(followingUrl).append(organizationsUrl).append(login).append(starredUrl).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Owner) == false) {
            return false;
        }
        Owner rhs = ((Owner) other);
        return new EqualsBuilder().append(eventsUrl, rhs.eventsUrl).append(siteAdmin, rhs.siteAdmin).append(gistsUrl, rhs.gistsUrl).append(type, rhs.type).append(gravatarId, rhs.gravatarId).append(subscriptionsUrl, rhs.subscriptionsUrl).append(url, rhs.url).append(followersUrl, rhs.followersUrl).append(id, rhs.id).append(reposUrl, rhs.reposUrl).append(htmlUrl, rhs.htmlUrl).append(nodeId, rhs.nodeId).append(receivedEventsUrl, rhs.receivedEventsUrl).append(avatarUrl, rhs.avatarUrl).append(followingUrl, rhs.followingUrl).append(organizationsUrl, rhs.organizationsUrl).append(login, rhs.login).append(starredUrl, rhs.starredUrl).isEquals();
    }

}
