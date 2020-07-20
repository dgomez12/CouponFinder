import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Coupon, NoIdCoupon } from '../interfaces/coupon';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class CouponService {

  constructor(
    private http: HttpClient
  ) { }

  getAllCoupon(){
    return this.http.get<Coupon[]>(environment.API_URL + "/coupons");
  }

  delete(id: number){
    return this.http.delete<Coupon[]>(environment.API_URL + `/coupons/${id}`);
  }

  update(id: number, coupon: NoIdCoupon){
    try{
      return this.http.put<Coupon[]>(environment.API_URL + `/coupons/${id}`, coupon);
    }catch(error){
      console.log(error);
    }
  }

  newCoupon(coupon: NoIdCoupon){
    return this.http.post<Coupon[]>(environment.API_URL + "/coupons", coupon);
  }

  getNew(){
    return this.http.get<Coupon[]>(environment.API_URL + "/coupons/desc");
  }

  sort(category: String){
    return this.http.get<Coupon[]>(environment.API_URL + `/coupons/${category}`);
  }
}
