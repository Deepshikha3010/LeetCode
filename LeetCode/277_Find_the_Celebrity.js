/**
 * Two Pass
 * 时间复杂度n，空间复杂度1
 */

var solution = function(knows) {
  /**
   * @param {integer} n Total people
   * @return {integer} The celebrity
   */
  return function(n) {
      if(n <= 0){
          return -1;
      }
      let crt = 0
      for(let i = 1; i < n; i++){
          if(knows(crt, i)){
              crt = i;
          }
      }
      for(let i = 0; i < n; i++){
          if(i !== crt && knows(crt, i)){
              return -1;
          }
      }
      return crt;
  };
};