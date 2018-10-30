
package com.am.innovations.badger.dto.git;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class License implements Serializable
{

    private String key;
    private String name;
    private String spdxId;
    private String url;
    private String nodeId;
    private final static long serialVersionUID = -1610797039784645790L;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpdxId() {
        return spdxId;
    }

    public void setSpdxId(String spdxId) {
        this.spdxId = spdxId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("key", key).append("name", name).append("spdxId", spdxId).append("url", url).append("nodeId", nodeId).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nodeId).append(spdxId).append(name).append(url).append(key).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof License) == false) {
            return false;
        }
        License rhs = ((License) other);
        return new EqualsBuilder().append(nodeId, rhs.nodeId).append(spdxId, rhs.spdxId).append(name, rhs.name).append(url, rhs.url).append(key, rhs.key).isEquals();
    }

}
