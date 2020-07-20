import { Component, OnInit } from '@angular/core';
import { Coupon, NoIdCoupon } from 'src/app/interfaces/coupon';
import { CouponService } from 'src/app/services/coupon.service';
import { faTrashAlt, faEdit, faPlus, faSortAmountUp } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  coupons: Coupon[];
  product = "";
  updateForm: NoIdCoupon = {
    couponOffer: '',
    couponProduct: '',
    couponDescription: '',
    couponCode: '',
    couponCategory: ''
  };
  currentId: number;
  dropdown = {
    auto: "auto",
    app: "app",
    food: "food",
    retail: "retail",
    school: "school"
  };
  faTrashAlt = faTrashAlt;
  faEdit = faEdit;
  faPlus = faPlus;
  faSortAmountUp = faSortAmountUp;
  alertMessage: String = '';

  constructor(
    private couponService: CouponService,
    ) {}

  ngOnInit(): void {
    this.couponService.getAllCoupon().subscribe((data) => {
      this.coupons = data;
    })
  }

  search(){
    if(this.product != ""){
      this.coupons = this.coupons.filter(res => {
        return res.couponProduct.toLocaleLowerCase().match(this.product.toLocaleLowerCase());
      });
    }else if(this.product == ""){
      this.ngOnInit();
    }
  }

  deleteCoupon(id: number){
    this.couponService.delete(id).subscribe((data => {
      this.coupons = data;
      this.alertMessage = 'Successfully Deleted Coupon';
    }));
  }

  updateCoupon(){
    this.couponService.update(this.currentId, this.updateForm).subscribe((data => {
      this.coupons = data;
      this.alertMessage = 'Successfully Updated Coupon';
    }));
  }

  orderByNew(){
    this.couponService.getNew().subscribe((data => {
      this.coupons = data;
    }));
  }

  createCoupon(){
    this.couponService.newCoupon(this.updateForm).subscribe((data => {
      this.coupons = data;
      this.reset();
      this.alertMessage = 'Successfully Created Coupon';
    }));
  }

  sortByCategory(category: String){
    this.couponService.sort(category).subscribe((data => {
      this.coupons = data;
    }))
  }

  openEdit(coupon: Coupon){
    this.currentId = coupon.couponId;
    this.updateForm.couponOffer = coupon.couponOffer;
    this.updateForm.couponProduct = coupon.couponProduct;
    this.updateForm.couponDescription = coupon.couponDescription;
    this.updateForm.couponCode = coupon.couponCode;
    this.updateForm.couponCategory = coupon.couponCategory;
    document.getElementById("uForm").style.display = "block";
  }

  closeEdit(){
    document.getElementById("uForm").style.display = "none";
  }

  openCreate(){
    this.reset();
    document.getElementById("cForm").style.display = "block";
  }

  closeCreate(){
    document.getElementById("cForm").style.display = "none";
  }

  reset(){
    this.updateForm.couponOffer = '';
    this.updateForm.couponProduct = '';
    this.updateForm.couponDescription = '';
    this.updateForm.couponCode = '';
    this.updateForm.couponCategory = '';
  }

  closeAlert(){
    this.alertMessage = '';
  }

}
