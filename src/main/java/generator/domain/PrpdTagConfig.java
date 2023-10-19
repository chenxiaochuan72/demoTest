package generator.domain;

import java.io.Serializable;

/**
 * 燃气险标签配置表
 * @TableName PRPD_TAG_CONFIG
 */

public class PrpdTagConfig implements Serializable {
    /**
     * 标签代码
     */
    private String tagcode;

    /**
     * 标签名称
     */
    private String tagname;

    /**
     * 险种代码
     */
    private String riskcode;

    /**
     * 产品代码
     */
    private String productcode;

    private static final long serialVersionUID = 1L;

    /**
     * 标签代码
     */
    public String getTagcode() {
        return tagcode;
    }

    /**
     * 标签代码
     */
    public void setTagcode(String tagcode) {
        this.tagcode = tagcode;
    }

    /**
     * 标签名称
     */
    public String getTagname() {
        return tagname;
    }

    /**
     * 标签名称
     */
    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    /**
     * 险种代码
     */
    public String getRiskcode() {
        return riskcode;
    }

    /**
     * 险种代码
     */
    public void setRiskcode(String riskcode) {
        this.riskcode = riskcode;
    }

    /**
     * 产品代码
     */
    public String getProductcode() {
        return productcode;
    }

    /**
     * 产品代码
     */
    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PrpdTagConfig other = (PrpdTagConfig) that;
        return (this.getTagcode() == null ? other.getTagcode() == null : this.getTagcode().equals(other.getTagcode()))
            && (this.getTagname() == null ? other.getTagname() == null : this.getTagname().equals(other.getTagname()))
            && (this.getRiskcode() == null ? other.getRiskcode() == null : this.getRiskcode().equals(other.getRiskcode()))
            && (this.getProductcode() == null ? other.getProductcode() == null : this.getProductcode().equals(other.getProductcode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTagcode() == null) ? 0 : getTagcode().hashCode());
        result = prime * result + ((getTagname() == null) ? 0 : getTagname().hashCode());
        result = prime * result + ((getRiskcode() == null) ? 0 : getRiskcode().hashCode());
        result = prime * result + ((getProductcode() == null) ? 0 : getProductcode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tagcode=").append(tagcode);
        sb.append(", tagname=").append(tagname);
        sb.append(", riskcode=").append(riskcode);
        sb.append(", productcode=").append(productcode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}