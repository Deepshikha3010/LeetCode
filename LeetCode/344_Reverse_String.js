// 普通做法
var reverseString = function(s) {
  if(!s || s.length === 0){
      return s;
  }
  let result = '';
  for(let i = s.length - 1; i >= 0; i--){
      const c = s.charAt(i);
      result += c;
  }
  return result;
};

// 转换array, reverse, 还原string
var reverseString = function(s) {
  if(!s || s.length === 0){
      return s;
  }
  return s.split('').reverse().join('');
};