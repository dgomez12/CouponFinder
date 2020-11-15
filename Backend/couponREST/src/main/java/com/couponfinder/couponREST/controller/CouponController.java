package com.couponfinder.couponREST.controller;

import com.couponfinder.couponREST.entity.Coupon;
import com.couponfinder.couponREST.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/coupons")
    public Iterable<Coupon> list(){
        return couponService.listAll();
    }
    @GetMapping("/coupons/{category}")
    public Iterable<Coupon> getCouponByCategory(@PathVariable String category){
        return couponService.getByCategory(category);
    }
    @GetMapping("/coupons/desc")
    public Iterable<Coupon> listDesc(){
        return couponService.listAllDesc();
    }
    @PostMapping("/coupons")
    public Iterable<Coupon> add(@RequestBody Coupon coupon){
        couponService.save(coupon);
        return couponService.listAll();
    }
    @PutMapping("/coupons/{id}")
    public Iterable<Coupon> update(@RequestBody Coupon coupon, @PathVariable long id) {
            coupon.setCouponId(id);
            couponService.save(coupon);
            return couponService.listAll();
    }
    @DeleteMapping("/coupons/{id}")
    public Iterable<Coupon> delete(@PathVariable long id){
        couponService.deleteById(id);
        return couponService.listAll();
    }
}
