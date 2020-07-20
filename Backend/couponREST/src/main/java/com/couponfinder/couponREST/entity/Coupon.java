package com.couponfinder.couponREST.entity;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long couponId;
    @Column(name = "coupon_offer")
    private String couponOffer;
    @Column(name = "coupon_product")
    private String couponProduct;
    @Column(name = "coupon_description")
    private String couponDescription;
    @Column(name = "coupon_code")
    private String couponCode;
    @Column(name = "coupon_category")
    private String couponCategory;

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponOffer() {
        return couponOffer;
    }

    public void setCouponOffer(String couponOffer) {
        this.couponOffer = couponOffer;
    }

    public String getCouponProduct() {
        return couponProduct;
    }

    public void setCouponProduct(String couponProduct) {
        this.couponProduct = couponProduct;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponCategory() {
        return couponCategory;
    }

    public void setCouponCategory(String couponCategory) {
        this.couponCategory = couponCategory;
    }
}
