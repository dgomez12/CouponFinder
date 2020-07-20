import { Pipe, PipeTransform } from '@angular/core';
@Pipe({
  name: 'couponFilter'
})
export class SearchPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (!args) {
      return value;
    }
    return value.filter((val) => {
      let rVal = (val.id.toLocaleLowerCase().includes(args)) || (val.filter.toLocaleLowerCase().includes(args));
      return rVal;
    })

  }

}