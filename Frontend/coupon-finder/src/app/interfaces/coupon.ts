export interface Coupon{
    couponId: number;
    couponOffer: String;
    couponProduct: String;
    couponDescription: String;
    couponCode: String;
    couponCategory: String;
}

export interface NoIdCoupon{
    couponOffer: String;
    couponProduct: String;
    couponDescription: String;
    couponCode: String;
    couponCategory: String;
}
