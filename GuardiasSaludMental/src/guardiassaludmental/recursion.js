/*
https://www.youtube.com/watch?v=DICBCBZn_L4&t=1161s
*/

// Factorial of n
// n = 5 => 5*4*3*2*1

function factorial(n){
    if(n===0){
        return 1;
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


console.log(reverseString("hola"));

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
// conjunto. El producto cartesiano desglosado

function combinaciones(elementos) {

    //  Inicializa dos vectores: "resultado" y "temporal". 
    //  resultado almacena todas las combinaciones de elementos posibles, empezando en vacío,
    //  temporal almacenará cada subconjunto construido.

    let resultado = [];
    let temporal = [];


    //  La función recursiva es definida dentro del conjunto. 
    //  Esta función toma dos argumentos: elementos (el vector ingresado) 
    //  e i (un índice que realiza un seguimiento sobre el elemento actual).

    function recursiva(elementos, i) {


        // Caso base, cuando i toma el valor de la longitud del vector
        // significa que ya recorrimos todos los elementos.
        // En este punto, insertamos una copia del vector temporal a resultado
        // esto asegura que no enviemos una referencia a temporal, y así
        // preservamos las combinaciones encontradas.

        if (i === elementos.length) {
            return resultado.push([...temporal]);
        }


        // temp.push(elementos[i]): es llamado para agregar el elemento actual 
        // en el índice i al vector temp, incluyéndolo como la combinación actual. 
        
        temporal.push(elementos[i]);


        // recursive(nums, i + 1); es llamado para generar recursivamente 
        // subconjuntos incluyendo el elemento actual en el índice i.
        
        recursiva(elementos, i + 1);


        // temp.pop();remueve el último elemento agregado al vector temp, 
        // excluyéndolo de la combinación actual.
        
        temporal.pop();

        recursiva(elementos, i + 1);
    }
    recursiva(elementos, 0);
    return resultado;
}
let combinetas = combinaciones(["a","b","c","d","e"]);

// prueba para aplicar condiciones por afuera de la función
let comDeTres = [];
for(const com of combinetas) {
    if(com.length==3){comDeTres.push(com)};
}
console.log(comDeTres);



const numeros = [1,2,3,4,5,6,7,10,11,12];

const palos = ["basto","copa","espada","oro"];

const cartas = [];

for (let i = 0; i < numeros.length; i++) {
    for (let j = 0; j < palos.length; j++) {
        cartas.push(numeros[i]+" "+palos[j])
    }
}

const naipes = cartas.map(item => item.split(' '));

function manos(naipes,limite) {

    let result = [];
    let temp = [];

    function recursiv(naipes, i) {
        if (i === naipes.length) {
            if(temp.length===limite){
            result.push([...temp]);
           }
           return;
        }

        temp.push(naipes[i]);

        recursiv(naipes, i + 1);

        temp.pop();

        recursiv(naipes, i + 1);
    }
    recursiv(naipes, 0);
    return result;
}

// cartas[16],cartas[17],cartas[18],cartas[19], cartas[20],cartas[21],cartas[22],cartas[23],cartas[24], cartas[25],cartas[26],cartas[27],cartas[28],cartas[29],cartas[30],cartas[31],cartas[32],cartas[33],cartas[34], cartas[35],cartas[36],cartas[37],cartas[38],cartas[39], cartas[40]

let juegos = manos([cartas[0],cartas[1],cartas[2],cartas[3],cartas[4],cartas[5],cartas[6],cartas[7],cartas[8],cartas[9],cartas[10],cartas[11],cartas[12],cartas[13],cartas[14],cartas[15],cartas[16],cartas[17],cartas[18],cartas[19],cartas[20],cartas[21],cartas[22],cartas[23],cartas[24],cartas[25],cartas[26],cartas[27],cartas[28],cartas[29],cartas[30],cartas[31],cartas[32],cartas[33],cartas[34],cartas[35],cartas[36],cartas[37],cartas[38],cartas[39]],3);

console.log(naipes);
console.log(juegos);