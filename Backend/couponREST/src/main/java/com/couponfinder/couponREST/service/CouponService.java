package com.couponfinder.couponREST.service;

import com.couponfinder.couponREST.entity.Coupon;
import com.couponfinder.couponREST.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    @Autowired
    private CouponRepository repo;

    public Iterable<Coupon> listAll(){
        return repo.findAll();
    }
    public void save(Coupon coupon){
        repo.save(coupon);
    }
    public Coupon getById(Long id){
        return repo.findById(id).get();
    }
    public Iterable<Coupon> getByCategory(String category){
        return repo.findCouponByCouponCategory(category);
    }
    public Iterable<Coupon> getByProduct(String product){
        return repo.findCouponsByCouponProduct(product);
    }
    public void delete(Coupon coupon){
        repo.delete(coupon);
    }
    public void deleteById(Long id){
        repo.delete(repo.findById(id).get());
    }
    public Iterable<Coupon> listAllDesc(){
        return repo.findAllByOrderByCouponIdDesc();
    }
}
