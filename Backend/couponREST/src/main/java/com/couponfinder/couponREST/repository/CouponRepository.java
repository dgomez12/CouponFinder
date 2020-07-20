package com.couponfinder.couponREST.repository;

import com.couponfinder.couponREST.entity.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

    Iterable<Coupon> findCouponByCouponCategory(@Param("couponCategory") String couponCategory);

    Iterable<Coupon> findAllByOrderByCouponIdDesc();

    Iterable<Coupon> findCouponsByCouponProduct(@Param("couponProduct") String couponProduct);

    Coupon deleteCouponByCouponId(@Param("couponId") Long couponId);

}
