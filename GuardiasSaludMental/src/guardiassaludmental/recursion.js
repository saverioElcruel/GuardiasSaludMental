/*
https://www.youtube.com/watch?v=DICBCBZn_L4&t=1161s
*/

// Factorial of n
// n = 5 => 5*4*3*2*1

function factorial(n){
    if(n===0){
        return 1;
        debugger;
    }else{
        return n * factorial(n-1);
    }
}

console.log(factorial(3));

function rangoDeNumeros(numInicio,numFin){
    if(numFin<numInicio){
        return [];
    }else{
        const numeros = rangoDeNumeros(numInicio,numFin-1);
        numeros.push(numFin);
        return numeros;
    }
}

// rangoDeNumeros(1,)

console.log(rangoDeNumeros(1,5));

// Dar vuelta un string con recursión

function reverseString(str){
    if(str===""){
        return "";
    }else{
        return reverseString(str.substr(1)) +str.charAt(0);
    }
}


console.log(reverseString("cacapedo"));

// reverseString("hola") => reverseString("ola")+h
// reverseString("ola") => reverseString("la")+o
// reverseString("la") => reverseString("a")+l
// reverseString("a") => reverseString("") +a 
// reverseString("") => ""  
// reverseString("a") => "" + a 
// reverseString("la") => a + l
// reverseString("ola") => a + l + o
// reverseString("hola") => a + l + o + h



// reverseString("") => ""  

// Encontrar todas las posibles combinaciones de un
// conjunto. El producto cartesiano

function subSet(nums) {
    let result = [];
    let temp = [];
    function recursive(nums, i) {
        if (i === nums.length) {
            return result.push([...temp]);
        }
        temp.push(nums[i]);
        recursive(nums, i + 1);

        temp.pop();
        recursive(nums, i + 1);
    }
    recursive(nums, 0);
    return result
}

console.log(subSet([1,2,3]));

let temporal=[];
temporal.push(1);
temporal.push(2);
temporal.pop();
console.log(temporal);