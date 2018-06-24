/**
 * Stack只存放前面运算符为+-的数字，用sign记录前面的运算符，用pre+while记录一个多位数字。
 * 时间复杂度n,空间复杂度n
 */

var calculate = function(s) {
  if (!s) {
    return 0;
  }
  s = s.trim();
  if (s.length === 0) {
    return 0;
  }
  const stack = [];
  let result = 0;
  let sign = '+';
  for (let i = 0; i < s.length; i++) {
    const crt = s.charAt(i);
    if (crt === ' '){
      continue;
    }
    if ('0123456789'.indexOf(crt) !== -1) {
      // number
      let pre = crt;
      while (i + 1 < s.length && '0123456789'.indexOf(s.charAt(i + 1)) !== -1) {
        i++;
        pre += s.charAt(i);
      }
      console.log(pre);
      if (sign === '+') {
        stack.push(Number(pre));
      } else if (sign === '-') {
        stack.push(-Number(pre));
      } else if (sign === '*') {
        const num = stack.pop() * Number(pre);
        stack.push(num);
      } else {
        const num = parseInt(stack.pop() / Number(pre));
        stack.push(num);
      }
    } else {
      // sign
      sign = crt;
    }
  }
  stack.forEach(function(num) {
    result += num;
  });
  return result;
};
