/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if(x[0]==x[x.length]){
            return true;
        }else{
            return false;
        }
};

console.log(isPalindrome(121));