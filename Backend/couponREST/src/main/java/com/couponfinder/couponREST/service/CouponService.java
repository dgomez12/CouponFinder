package com.couponfinder.couponREST.service;

import com.couponfinder.couponREST.entity.Coupon;
import com.couponfinder.couponREST.repository.CouponRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private static WebDriver driver;

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
    @Scheduled(fixedDelay = 60000)
    public void getMcDonaldsCoupon(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.mcdonalds.com/us/en-us/deals.html");

        String couponOffer = driver.findElement(By.xpath("/html/body/main/div[1]/div[3]/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div[1]/h3")).getText();

        System.out.println(couponOffer);

        if(driver != null) {
            driver.close();
        }
    }
}
