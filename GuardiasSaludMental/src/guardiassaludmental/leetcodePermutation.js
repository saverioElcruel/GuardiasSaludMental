/*

https://leetcode.com/problems/permutation-sequence/description/

The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
*/



function combinaciones(n,k) {
    let result = [];
    let temp = [];
    let contador= 0;
  
    function generateCombinations(start) {
      if (temp.length === n) {
        contador++;
        result.push([...temp]);
        return;
      }
  
      for (let i = start; i <= n; i++) {
        if(!temp.includes(i)){
            temp.push(i);
            generateCombinations(1);
            temp.pop(); // Backtrack
        }
      }
    }
  
    generateCombinations(1);
    return result[k];
  }
  
 
console.log(combinaciones(4,9));
