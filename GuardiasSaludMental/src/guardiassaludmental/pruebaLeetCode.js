// Mostrar por pantalla los primeros n números naturales, siendo n un valor ingresado por el usuario.

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

console.log(fg(9));




/*
var sortColors = function(nums) {
    for (const num of nums) {
        n = nums.length/2;
        switch (num) {
            case 0:
                nums.pop(num)
                nums.unshift(num)
                break;
            case 2:
                nums.pop(num)
                nums.push(num)
                break;
        }
    }
    return nums;
};


console.log(sortColors([1,0,2,1,0,2]))


var removeKdigits = function(num, k) {
    
    let nums = [num.length];

    for (const iterator of object) {
        
    }

};
*/