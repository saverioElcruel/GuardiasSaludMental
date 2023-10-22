// Mostrar por pantalla los primeros n números naturales, siendo n un valor ingresado por el usuario.
/*
function fg(n) {
    let result = [];
    function recursiv(n, result) {
        if (n > 0) {
            recursiv(n - 1, result);
        }
        result.push(n);
    }
    recursiv(n, result);
    return result;
}

console.log(fg(20));
*/

/*
var removeKdigits = function(num, k) {
    let nums = [num.length];
    for (const iterator of object) {   
    }
};
*/

/*
    nums.pop(); // Borra el último elemento del array
    nums.push(5); // Añade nuevos elementos al array 
    nums.unshift(2); // Añade elementos al inicio del array
    nums.shift(); // Elimina el primer elemento del array
*/


/*
This code uses the bubble sort algorithm to sort the nums array
in ascending order. It compares adjacent elements and swaps 
them if they are out of order. The outer loop runs for n times,
and the inner loop compares and swaps elements as needed. 
Finally, the sorted array is returned.


var sortBinario = function(nums) {
    const n = nums.length;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < n - i - 1; j++) {
            if (nums[j] > nums[j + 1]) {
                // Swap the elements
                const temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }

    return nums;
}

console.log(sortBinario([1, 0, 2, 1, 0, 1, 0, 2, 0]));


var twoSum = function(nums, target) {
    let n = nums.length;
    let result= []
    for (let i = 0; i < n; i++) {
        for (let j = n; j > i; j--) {
            if(nums[i]!==nums[j]&&(nums[i]+nums[j])===target){
                result.push(i);
                result.push(j);
            }
        }
    }
    return result;
};

console.log(twoSum([3,4,5,7,1],6));

Given a string s, find the length of the longest 
substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

var cadenaNueva = function(s) {
    cadena="";
    for (let i = 0; i < s.length; i++) {
        const letra = s.charAt(i);
        if(!cadena.includes(letra)&&letra[i+1]!==letra){       
        cadena = cadena.concat(letra);
        }
    }
    return cadena.length;
};
console.log(cadenaNueva("pwwkew"));

console.log(cadena.substring(0,2))